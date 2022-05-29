package wingeddev.example.hashingapplication.presentation.resultFragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import wingeddev.example.hashingapplication.R
import wingeddev.example.hashingapplication.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        // get result from bundle
        val result = arguments?.get("result").toString()
        binding.resultTV.text = result

        // navigation
        binding.backIB.setOnClickListener {
            findNavController().navigate(R.id.selectionFragment)
        }

        binding.copyBTN.setOnClickListener {
            val clipboard = requireContext()
                .getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copiedHash", result)
            clipboard.setPrimaryClip(clip)
            Snackbar.make(binding.root, "Copied!", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // prevents memory leaks
    }
}