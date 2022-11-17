package com.sgcp.fourth_app_test

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sgcp.fourth_app_test.controller.AdapterTareas
import com.sgcp.fourth_app_test.data.Tarea

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TareasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TareasFragment : Fragment() {

    var globalID = 0;

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapterTareas: AdapterTareas;
    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_tareas, container, false);


        val dataBundle = arguments;
        dataBundle?.getInt("IDUSER")?.let {
            globalID = it;
        };

        Toast.makeText(context, "ID: ${globalID}", Toast.LENGTH_LONG).show();

        return rootView;
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_lista_tareas);
        recyclerView.layoutManager = layoutManager;
        recyclerView.setHasFixedSize(true);
        adapterTareas = AdapterTareas(getTareasList());
        recyclerView.adapter = adapterTareas;

        adapterTareas.onItemClick = {
            Toast.makeText(context, "ID: ${it.id}", Toast.LENGTH_LONG).show();
            parentFragmentManager.commit {
                val fmanager = parentFragmentManager;
                val fmanagerTrans = fmanager.beginTransaction();
                val fragment = TareaDetailFragment();

                val databundle = Bundle();
                if ( it.id != null) {
                    databundle.putInt("IDTAREA", it.id);
                }
                fragment.arguments = databundle;
                fmanagerTrans.replace(R.id.fcv_main_container, fragment)
                    .setReorderingAllowed(true)
                    .addToBackStack("principal")
                    .commit();
            }
        }
    }

    fun getTareasList(): ArrayList<Tarea> {
        var tareasList : ArrayList<Tarea> = ArrayList();

        val admin = BaseDatosAPP(context, "bd", null, 1);
        val bd = admin.writableDatabase;

        val reg = bd.rawQuery("SELECT ID, NOMBRE, DESCRIPCION, IMAGEN, USER FROM Tareas WHERE USER='${globalID}'", null);

        var id = 0;
        var name = "";
        var desc = "";
        var img = 0;
        var user = 0;

        if ( reg.moveToFirst()) {
            do {
                id = reg.getString(0).toInt();
                name = reg.getString(1);
                desc = reg.getString(2);
                img = reg.getString(3).toInt();
                user = reg.getString(4).toInt();
                tareasList.add(Tarea(id, name, desc, img, user));
            } while ( reg.moveToNext())
        }

        return tareasList;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TareasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TareasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}