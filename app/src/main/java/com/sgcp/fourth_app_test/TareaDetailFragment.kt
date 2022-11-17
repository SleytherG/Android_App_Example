package com.sgcp.fourth_app_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TareaDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TareaDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var globalID = 0;

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
        val rootView: View = inflater.inflate(R.layout.fragment_tarea_detail, container, false);

        val databundle = arguments;
        if ( databundle != null) {
            globalID = databundle.getInt("IDTAREA")
        }

        Toast.makeText(context, "ID dentro de tarea detail: ${globalID}", Toast.LENGTH_LONG).show();

        val imagenTarea: ImageView = rootView.findViewById(R.id.iv_tarea_detail);
        val nombreTarea: TextView = rootView.findViewById(R.id.tv_tarea_name_detail);
        val descTarea: TextView = rootView.findViewById(R.id.tv_tarea_desc_detail);

        val admin = BaseDatosAPP(context, "bd", null, 1);
        val bd = admin.writableDatabase;
        val reg = bd.rawQuery("SELECT ID, NOMBRE, DESCRIPCION, IMAGEN, USER FROM Tareas WHERE ID= ${globalID}", null);

        println(reg);

        if ( reg.moveToFirst()) {
            nombreTarea.text = reg.getString(1);
            descTarea.text = reg.getString(2);
            imagenTarea.setImageResource(reg.getInt(3));
        }
        bd.close();
        return rootView;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TareaDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TareaDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}