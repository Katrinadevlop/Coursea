package com.example.coursea

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.common.MobileAds

class CoursesActivity : AppCompatActivity() {
    private var bannerAd: BannerAdView? = null
    private lateinit var adContainerView: FrameLayout

    private val adSize: BannerAdSize
        get() {
            var adWidthPixels = adContainerView.width
            if (adWidthPixels == 0) {
                adWidthPixels = resources.displayMetrics.widthPixels
            }
            val adWidth = (adWidthPixels / resources.displayMetrics.density).toInt()
            return BannerAdSize.stickySize(this, adWidth)
        }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {}
        MobileAds.enableDebugErrorIndicator(true)

        setContentView(R.layout.courses_activity)

        adContainerView = findViewById(R.id.adContainerView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adContainerView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                adContainerView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                bannerAd = loadBannerAd(adSize)
            }
        })
    }

    private fun loadBannerAd(adSize: BannerAdSize): BannerAdView {
        val bannerView: BannerAdView = findViewById(R.id.banner)
        bannerView.setAdSize(adSize)
        bannerView.setAdUnitId("R-M-12488085-1")
        bannerView.setBannerAdEventListener(object : BannerAdEventListener {
            override fun onAdLoaded() {
                if (isDestroyed) {
                    bannerAd?.destroy()
                    return
                }
            }

            override fun onAdFailedToLoad(adRequestError: AdRequestError) {
                // Обработка ошибки загрузки объявления
            }

            override fun onAdClicked() {
                // Обработка клика по объявлению
            }

            override fun onLeftApplication() {
                // Обработка ухода из приложения после клика
            }

            override fun onReturnedToApplication() {
                // Обработка возврата в приложение
            }

            override fun onImpression(impressionData: ImpressionData?) {
                // Обработка показа рекламы
            }
        })
        bannerView.loadAd(AdRequest.Builder().build())
        return bannerView
    }
}