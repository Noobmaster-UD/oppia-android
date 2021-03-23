package org.oppia.android.app.feedbackreporting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.oppia.android.app.viewmodel.ViewModelProvider
import org.oppia.android.databinding.FeedbackReportingEntryFragmentBinding
import javax.inject.Inject

/** Presenter for the [FeedbackReportingEntryFragment] */
class FeedbackReportingEntryFragmentPresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val fragment: Fragment,
  private val viewModelProvider: ViewModelProvider<FeedbackReportingEntryViewModel>
) {
  private lateinit var binding: FeedbackReportingEntryFragmentBinding

  fun handleCreateView(inflater: LayoutInflater, container: ViewGroup?): View? {
    val viewModel = getFeedbackReportingEntryViewModel()

    binding = FeedbackReportingEntryFragmentBinding.inflate(
      inflater,
      container,
      /* attachToRoot = */ false
    )

    binding.let {
      it.lifecycleOwner = fragment
      it.viewModel = viewModel
    }
    return binding.root
  }

  private fun getFeedbackReportingEntryViewModel(): FeedbackReportingEntryViewModel {
    return viewModelProvider.getForFragment(fragment, FeedbackReportingEntryViewModel::class.java)
  }
}