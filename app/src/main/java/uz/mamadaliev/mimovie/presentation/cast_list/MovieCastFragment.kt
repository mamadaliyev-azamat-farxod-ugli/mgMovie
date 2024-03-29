package uz.mamadaliev.mimovie.presentation.cast_list

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.mamadaliev.mimovie.R
import uz.mamadaliev.mimovie.databinding.FragmentMovieCastBinding
import uz.mamadaliev.mimovie.presentation.BaseFragment
import uz.mamadaliev.mimovie.presentation.adapter.CastLimitlessAdapter
import uz.mamadaliev.mimovie.presentation.movie_detail.MovieDetailViewModel

@AndroidEntryPoint
class MovieCastFragment : BaseFragment<FragmentMovieCastBinding>(FragmentMovieCastBinding::inflate) {
    private val viewModel: MovieDetailViewModel by viewModels()
    private val adapter by lazy {
        CastLimitlessAdapter()
    }
    override fun onViewCreate() {
        val id = requireArguments().getLong("MOVIE_ID", 0)

        viewModel.getCredits(id)

        binding.castList.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        binding.castList.adapter = adapter

        viewModel.creditsLiveData.observe(viewLifecycleOwner) {
            it.cast?.let { it1 -> adapter.setPersons(it1) }
        }

        adapter.setItemClickListener {
            val bundle = bundleOf("ACTOR_ID" to it)
            navController.navigate(R.id.action_movieCastFragment_to_actorsFragment, bundle)
        }
    }
}