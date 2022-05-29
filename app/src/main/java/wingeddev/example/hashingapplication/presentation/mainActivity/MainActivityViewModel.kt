package wingeddev.example.hashingapplication.presentation.mainActivity

import androidx.lifecycle.ViewModel
import wingeddev.example.hashingapplication.util.toMd5String
import wingeddev.example.hashingapplication.util.toSha256String
import wingeddev.example.hashingapplication.util.toSha512String

class MainActivityViewModel: ViewModel() {
    fun md5FromText(text: String): String {
        return text.toMd5String()
    }

    fun sha256FromText(text: String): String {
        return text.toSha256String()
    }

    fun sha512FromText(text: String): String {
        return text.toSha512String()
    }
}