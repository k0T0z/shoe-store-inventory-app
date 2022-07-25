package com.example.shoestore_starter

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore_starter.databinding.FragmentShoeListViewBinding
import com.example.shoestore_starter.modeks.Shoe


class ShoeListViewFragment : Fragment() {

    object Obj {
        lateinit var viewModel: ShoesList
        var name: String = ""
        var company: String = ""
        var size: String = ""
        var description: String = ""
    }

    private lateinit var binding: FragmentShoeListViewBinding

    private lateinit var linearLayout: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list_view, container, false
        )
//        Navigation.createNavigateOnClickListener(ShoeListViewFragmentDirections.actionShoeListViewFragmentToShoeDetailsFragment())
        linearLayout = binding.linearLayoutListId
        Obj.viewModel = ViewModelProvider(this)[ShoesList::class.java]
        binding.floatingActionButtonId.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListViewFragmentDirections.actionShoeListViewFragmentToShoeDetailsFragment())
        )

        val nameObserver = Observer<MutableList<Shoe>> {
            val parentLinearLayout = LinearLayout(context)
            parentLinearLayout.orientation = LinearLayout.HORIZONTAL
            parentLinearLayout.setBackgroundColor(Color.LTGRAY)
            parentLinearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            )


            val childLinearLayoutFirst = LinearLayout(context)
            childLinearLayoutFirst.orientation = LinearLayout.VERTICAL
            childLinearLayoutFirst.textAlignment = View.TEXT_ALIGNMENT_CENTER
            childLinearLayoutFirst.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F
            )


            val childLinearLayoutSecond = LinearLayout(context)
            childLinearLayoutSecond.orientation = LinearLayout.VERTICAL
            childLinearLayoutSecond.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F
            )


            val childTextViewFirst = TextView(context)
            childTextViewFirst.text = Obj.name
            childTextViewFirst.textSize = 48F
            childTextViewFirst.textAlignment = View.TEXT_ALIGNMENT_CENTER
            childTextViewFirst.setTextColor(Color.BLACK)
            childLinearLayoutFirst.addView(childTextViewFirst)

            val childTextViewSecondFirst = TextView(context)
            childTextViewSecondFirst.text = Obj.company
            childTextViewSecondFirst.textAlignment = View.TEXT_ALIGNMENT_CENTER
            childTextViewSecondFirst.textSize = 18F
            childTextViewSecondFirst.setTextColor(Color.BLACK)

            val childTextViewSecondSecond = TextView(context)
            childTextViewSecondSecond.text = Obj.size
            childTextViewSecondSecond.textAlignment = View.TEXT_ALIGNMENT_CENTER
            childTextViewSecondSecond.textSize = 18F
            childTextViewSecondSecond.setTextColor(Color.BLACK)

            val childTextViewSecondThird = TextView(context)
            childTextViewSecondThird.text = Obj.description
            childTextViewSecondThird.textAlignment = View.TEXT_ALIGNMENT_CENTER
            childTextViewSecondThird.textSize = 18F
            childTextViewSecondThird.setTextColor(Color.BLACK)

            childLinearLayoutSecond.addView(childTextViewSecondFirst)
            childLinearLayoutSecond.addView(childTextViewSecondSecond)
            childLinearLayoutSecond.addView(childTextViewSecondThird)

            parentLinearLayout.addView(childLinearLayoutFirst)
            parentLinearLayout.addView(childLinearLayoutSecond)

            linearLayout.addView(parentLinearLayout)
        }
        Obj.viewModel.listOfShoes.observe(viewLifecycleOwner, nameObserver)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}