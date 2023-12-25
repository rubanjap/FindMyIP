package com.example.findmyip.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findmyip.data.remote.IPInfo
import com.example.findmyip.domain.IpItem
import com.example.findmyip.domain.repository.FindMyIPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindMyIpViewModel  @Inject constructor(private val repository: FindMyIPRepository) : ViewModel(){


    private val _ipInfo = MutableStateFlow<List<IpItem>?>(null)
    val ipInfo: StateFlow<List<IpItem>?> get() = _ipInfo

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    fun fetchIpInfo() {
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = repository.getIpInfo()
                if (response.isSuccessful) {
                   // _ipInfo.value = response.body()
                    saveIpItems(response.body())

                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

     fun saveIpItems(ipInfo: IPInfo?) {
        val ipItems = mutableListOf(
            IpItem("Id", ipInfo?.ip),
            IpItem("network", ipInfo?.network),
            IpItem("version", ipInfo?.version),
            IpItem("city", ipInfo?.city),
            IpItem("region", ipInfo?.region),
            IpItem("region_code", ipInfo?.region_code),
            IpItem("country", ipInfo?.country),
            IpItem("Country Name", ipInfo?.country_name),
            IpItem("Country Code", ipInfo?.country_code),
            IpItem("Country Capital", ipInfo?.country_capital),
            IpItem("Country Tld", ipInfo?.country_tld),
            IpItem("Continent Code", ipInfo?.continent_code),
            IpItem("In Eu", if (ipInfo?.in_eu == true) "Yes" else "No"),
            IpItem("postal", ipInfo?.postal),
            IpItem("latitude", ipInfo?.latitude.toString()),
            IpItem("longitude", ipInfo?.longitude.toString()),
            IpItem("timezone", ipInfo?.timezone),
            IpItem("currency", ipInfo?.currency),
            IpItem("Currency Name", ipInfo?.currency_name),
            IpItem("languages", ipInfo?.languages),
            IpItem("Country Area", ipInfo?.country_area.toString()),
            IpItem("Country Population", ipInfo?.country_population.toString()),
            IpItem(" asn", ipInfo?.asn),
            IpItem(" org", ipInfo?.org)
        )

        _ipInfo.value = ipItems

    }
}
