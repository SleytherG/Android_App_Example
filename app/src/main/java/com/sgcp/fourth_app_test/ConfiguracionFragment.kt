package com.sgcp.fourth_app_test

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConfiguracionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfiguracionFragment : Fragment() {
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
        val rootView: View = inflater.inflate(R.layout.fragment_configuracion, container, false);
        val tv = rootView.findViewById<TextView?>(R.id.tv_rights);
        val changeFont: Switch = rootView.findViewById(R.id.sw_change_font);
        val addressBtn: Button = rootView.findViewById(R.id.btn_address);
        val aboutMeBtn: Button = rootView.findViewById(R.id.btn_about_me);
        val framePadre: FrameLayout = rootView.findViewById(R.id.linear_padre);
        val btnLuces: ToggleButton = rootView.findViewById(R.id.btn_luces);
        val tvLuces: TextView = rootView.findViewById(R.id.tv_luces);
        val webViewAD: WebView = rootView.findViewById(R.id.wv_about_me);

        btnLuces.setOnCheckedChangeListener{ buttonView, isChecked ->
            if ( isChecked ) {
                framePadre.setBackgroundColor(Color.WHITE);
                changeFont.setTextColor(Color.BLACK);
                tv.setTextColor(Color.BLACK);
                tvLuces.setTextColor(Color.BLACK);
            } else {
                framePadre.setBackgroundColor(Color.BLACK);
                changeFont.setTextColor(Color.WHITE);
                tv.setTextColor(Color.WHITE);
                tvLuces.setTextColor(Color.WHITE);
            }

        }

        changeFont.setOnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                val tf = context?.let { ResourcesCompat.getFont(it, R.font.supercell_magic) }
                tv.typeface = tf;
                addressBtn.typeface = tf;
                aboutMeBtn.typeface = tf;
            } else {
                tv.typeface = Typeface.DEFAULT;
                addressBtn.typeface = Typeface.DEFAULT;
                aboutMeBtn.typeface = Typeface.DEFAULT;
            }
        }

        aboutMeBtn.setOnClickListener {
//            webViewAD.loadUrl("https://www.youtube.com/c/Danisable/videos");
            webViewAD.loadUrl("https://www.google.com");
        }

        addressBtn.setOnClickListener {
            parentFragmentManager.commit {
                replace<MapsFragment>(R.id.fcv_main_container)
                setReorderingAllowed(true);
                addToBackStack("principal")
            }
        }

        framePadre.setBackgroundColor(Color.BLACK);
        changeFont.setTextColor(Color.WHITE);
        tv.setTextColor(Color.WHITE);
        tvLuces.setTextColor(Color.WHITE);
        return rootView;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConfiguracionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConfiguracionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}