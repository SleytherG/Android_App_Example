package com.sgcp.fourth_app_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PrincipalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrincipalFragment : Fragment() {
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
        val rootView: View = inflater.inflate(R.layout.fragment_principal, container, false);

        val dataBundle = arguments;
        val user = dataBundle?.getString("USER");
        val id = dataBundle?.getInt("ID");

        Toast.makeText(context, "USER: ${user} | ID: ${id}", Toast.LENGTH_LONG).show();



//        Toast.makeText(context, "Usuario: ${user}", Toast.LENGTH_LONG).show();

        val tvUser: TextView = rootView.findViewById(R.id.tv_user_sesion);
//        tvUser.setText("Panel de ${user}");
        tvUser.setText("");
        tvUser.text = "Panel de ${user}";

        val btnTareas: ImageButton = rootView.findViewById(R.id.btnTareas);
        btnTareas.setOnClickListener {
//            Toast.makeText(context, "Redirect to Tareas", Toast.LENGTH_LONG).show();
//            parentFragmentManager.commit {
//                replace<TareasFragment>(R.id.fcv_main_container);
//                setReorderingAllowed(true);
//                addToBackStack("principal");
//            }
            val fmanager = parentFragmentManager;
            val fmanagerTrans = fmanager.beginTransaction();
            val fragment = TareasFragment();

            val databundle = Bundle();
            if ( id != null) {
                databundle.putInt("IDUSER", id);
            }
            fragment.arguments = databundle;
            fmanagerTrans.replace(R.id.fcv_main_container, fragment)
                .setReorderingAllowed(true)
                .addToBackStack("principal")
                .commit();
        }

        val btnAgregarTarea: ImageButton = rootView.findViewById(R.id.btnAgregarTarea);
        btnAgregarTarea.setOnClickListener {
            Toast.makeText(context, "Click en Tareas", Toast.LENGTH_LONG).show();

            val fmanager = parentFragmentManager;
            val fmanagerTrans = fmanager.beginTransaction();
            val fragment = AgregarTareaFragment();

            val databundle = Bundle();
            if ( id != null) {
                databundle.putInt("IDUSER", id);
            }
            fragment.arguments = databundle;
            fmanagerTrans.replace(R.id.fcv_main_container, fragment)
                .setReorderingAllowed(true)
                .addToBackStack("principal")
                .commit();
//            parentFragmentManager.commit {
//                val databundle = Bundle();
//                if ( id != null) {
//                    databundle.putInt("IDUSER", id);
//                }
//
//                replace<AgregarTareaFragment>(R.id.fcv_main_container);
//                setReorderingAllowed(true);
//                addToBackStack("principal");
//            }
        }

        val btnAgregarUsuario: ImageButton = rootView.findViewById(R.id.btnAgregarUsuario);
        btnAgregarUsuario.setOnClickListener {
//            Toast.makeText(context, "Click en Tareas", Toast.LENGTH_LONG).show();
            parentFragmentManager.commit {
                replace<AgregarUsuarioFragment>(R.id.fcv_main_container);
                setReorderingAllowed(true);
                addToBackStack("principal");
            }
        }

        val btnConfiguracion: ImageButton = rootView.findViewById(R.id.btnConfig);
        btnConfiguracion.setOnClickListener {
//            Toast.makeText(context, "Click en Tareas", Toast.LENGTH_LONG).show();
            parentFragmentManager.commit {
                replace<ConfiguracionFragment>(R.id.fcv_main_container);
                setReorderingAllowed(true);
                addToBackStack("principal");
            }
        }

        return rootView;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PrincipalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrincipalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}