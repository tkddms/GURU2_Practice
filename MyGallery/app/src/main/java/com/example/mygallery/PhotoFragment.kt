package com.example.mygallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_URI = "uri"

class PhotoFragment : Fragment() {
    private var uri: String? = null

    // 초기화 부분
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            uri = it.getString(ARG_URI)
        }
    }

    // 뷰 출력
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imageView: ImageView = view.findViewById(R.id.imageView)
        Glide.with(this).load(uri).into(imageView)
    }

    companion object {
        @JvmStatic
        fun newInstance(uri: String) =
                PhotoFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_URI, uri)
                    }
                }
    }
}