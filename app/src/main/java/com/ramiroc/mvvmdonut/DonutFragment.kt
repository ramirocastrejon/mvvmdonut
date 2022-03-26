package com.ramiroc.mvvmdonut

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ramiroc.mvvmdonut.databinding.FragmentDonutBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DonutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DonutFragment : Fragment() {

    private var _binding : FragmentDonutBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDonutBinding.inflate(inflater, container, false)
        val view = binding!!.root
        val application = requireNotNull(this.activity).application
        val dao = DonutDatabase.getInstance(application).donutDao
        val viewModelFactory = DonutViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(DonutViewModel::class.java)
        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner=viewLifecycleOwner

        return view
    }


}