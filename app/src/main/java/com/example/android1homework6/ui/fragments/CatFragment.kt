package com.example.android1homework6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android1homework6.R
import com.example.android1homework6.Repositories.CarRepository
import com.example.android1homework6.data.CatModel
import com.example.android1homework6.interfaces.OnItemClick
import com.example.android1homework6.ui.adapters.CatAdapter
import java.text.AttributedCharacterIterator.Attribute


class CatFragment : Fragment() , OnItemClick {

    private var recyclerView: RecyclerView? = null
    private var repository = CarRepository()
    private var carAdapter = CatAdapter(repository.getLisOfCat())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView_catFragment)

        recyclerView = view?.findViewById(R.id.recyclerView_catFragment)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = carAdapter
    }

    override fun onClick(catModel: CatModel) {
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putSerializable("Dan", catModel)

            parentFragmentManager.beginTransaction()
                .replace(R.id. fragment_container_view,detailFragment)
                .addToBackStack(null)
                .commit()
    }
}