package my.edu.tarc.contact

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import my.edu.tarc.contact.databinding.FragmentAddBinding
import my.edu.tarc.contact.databinding.FragmentSecondBinding
import my.edu.tarc.contact.model.Contact


/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
private var _binding:FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Add Fragment", "onCreateView")
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.findItem(R.id.action_save).isVisible = true
        menu.findItem(R.id.action_profile).isVisible = false
        menu.findItem(R.id.action_add).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                val name = binding.editTextTextPersonName.text.toString()
                val phone = binding.editTextPhone2.text.toString()
                val newContact = Contact(name,phone)

                //Add new contact to the contact list
                MainActivity.contactList.add(newContact)

                Toast.makeText(context, getString(R.string.contact_saved),
                    Toast.LENGTH_SHORT).show()
                true
                //val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
                findNavController().navigateUp()

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Add Fragment", "onDestroyView")
    }

}