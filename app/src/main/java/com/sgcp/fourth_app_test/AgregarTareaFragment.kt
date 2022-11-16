package com.sgcp.fourth_app_test

import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarTareaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarTareaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val pickImage = 0;
    private var imageUri: Uri? = null;
    lateinit var imgCargada: ImageView

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

        val rootView = inflater.inflate(R.layout.fragment_agregar_tarea, container, false);

        imgCargada = rootView.findViewById(R.id.iv_imagen_cargada);
        val btnSeleccionarImagen: Button = rootView.findViewById(R.id.btn_img_tarea);
        btnSeleccionarImagen.setOnClickListener {
            val galeria = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(galeria, pickImage);
        }

        val nombreTarea: EditText = rootView.findViewById(R.id.et_nombre_tarea);
        val descTarea: EditText = rootView.findViewById(R.id.et_desc_tarea);

        val btnAgregarTarea: Button = rootView.findViewById(R.id.btn_agregar_tarea);

        btnAgregarTarea.setOnClickListener {
            val admin = BaseDatosAPP(context, "bd", null, 1);
            val bd = admin.writableDatabase;
            val reg = ContentValues();

            reg.put("NOMBRE", nombreTarea.text.toString());
            reg.put("DESCRIPCION", descTarea.text.toString());
            reg.put("IMAGEN", R.mipmap.img_2);
            reg.put("USER", 1);

            bd.insert("Tareas", null, reg);
            bd.close();

            nombreTarea.setText("");
            descTarea.setText("");
            Toast.makeText(context, "Se ha agregado la tarea correctamente.", Toast.LENGTH_LONG).show();
            nombreTarea.requestFocus();
        }

        return rootView;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data;
            imgCargada.setImageURI(imageUri);
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AgregarTareaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AgregarTareaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}