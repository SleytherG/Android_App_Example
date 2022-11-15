package com.sgcp.fourth_app_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val rootView = inflater.inflate(R.layout.fragment_tareas, container, false);

//        val tareas = arrayOf("Bugs menores", "Arreglar Vista", "Barrer el jardin", "Recoger ropa", "Cuidar mascotas");
//        val listaTareas: ListView = rootView.findViewById(R.id.lista_tareas);
//        val adaptador = context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, tareas) };
//        listaTareas.adapter = adaptador;





        return rootView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AdapterTareas(getTareasList());
    }

    fun getTareasList(): ArrayList<Tarea> {
        var tareasList : ArrayList<Tarea> = ArrayList();
        tareasList.add(Tarea(1, "Bugs menores", "Arreglar bugs menores de una app", R.mipmap.ic_launcher_round, 1));
        tareasList.add(Tarea(2, "Arreglar vista", "Arreglar vista de la pagina principal", R.mipmap.ic_launcher_round, 1));
        tareasList.add(Tarea(3, "Barrer Jardin", "Barrer el jardin o papá se molesta", R.mipmap.ic_launcher_round, 1));
        tareasList.add(Tarea(4, "Recoger la ropa", "Recoge la ropa de tu cuarto o mamá se enoja", R.mipmap.ic_launcher_round, 1));
        tareasList.add(Tarea(5, "Cuidar mascotas", "Saca a pasear a tus mascotas o enfermaran", R.mipmap.ic_launcher_round, 1));

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