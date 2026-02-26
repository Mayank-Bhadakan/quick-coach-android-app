package com.quickcoach.utils

import android.annotation.SuppressLint
import android.app.*
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.viewbinding.BuildConfig
import com.quickcoach.R
import com.quickcoach.customs.CustomDialog
import java.io.File
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Util
{
    private var customDialog: CustomDialog? = null
//    private var httpClient: OkHttpClient? = null

    fun print(message: String) {
        if (BuildConfig.DEBUG) {

            if (message.length > 1000) {
                val maxLogSize = 1000
                for (i in 0..message.length / maxLogSize) {
                    val start = i * maxLogSize
                    var end = (i + 1) * maxLogSize
                    end = if (end > message.length) message.length else end
                    Log.v("Print ::", message.substring(start, end))
                }
            } else {
                Log.i("Print ::", message)
            }
        }
    }


//    fun timePicker(
//        calendar: Calendar,
//        context: Context?,
//        timeView: TextView?,
//        responseListener: ResponseListener?, myDateFormat: String
//    ) {
//        val mHours = calendar[Calendar.HOUR_OF_DAY]
//        val mMinute = calendar[Calendar.MINUTE]
//        @SuppressLint("SetTextI18n") val timePicker =
//            TimePickerDialog(
//                context, AlertDialog.THEME_HOLO_LIGHT,
//                TimePickerDialog.OnTimeSetListener { _: TimePicker?, hourOfDay: Int, minute: Int ->
//
//                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
//                    calendar.set(Calendar.MINUTE, minute)
//
//                    if (timeView != null)
//                        timeView.text = convertDateToString(calendar.time, myDateFormat)
//                    /*
//
//                    timeView.text =   convertDateToString(cal.time, myDateFormat)  Util.getTextValue(timeView) +" " +  convertDateStringToString(
//                        "$hourOfDay:$minute",
//                        "HH:mm",
//                        "hh:mm a"
//                    )*/
//
//                    responseListener?.onResponse(
//                        DATE_TIME_CHANGE,
//                        SUCCESS,
//                        null
//                    )
//                }, mHours, mMinute, false
//            )
//        timePicker.show()
//    }

    /*fun handleRemoveUser(result: Int, msg: String) {
        if (result == 5 || result == 4) {
            showToastMessage(MainApplication.instance, msg, false)
            Pref.clearAllPref()
            MainApplication.instance.startActivity(
                Intent(
                    MainApplication.instance,
                    LoginActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
            if (BaseActivity.instace != null)
                BaseActivity.instace!!.finishAffinity()
        }
    }*/

    fun showProgress(context: Context) {
        try {
            if (customDialog != null && customDialog!!.isShowing)
                customDialog!!.dismiss()

            customDialog = CustomDialog(context)
            customDialog!!.setCancelable(false)
            customDialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun dismissProgress() {
        if (customDialog != null && customDialog!!.isShowing)
            customDialog!!.dismiss()
        customDialog = null
    }

    fun textSpannedColor(value: String, startNo: Int, endNo: Int,color:Int): SpannableString {
        val spannableString = SpannableString(value)
        spannableString.setSpan(ForegroundColorSpan(color),startNo,endNo, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)

        return spannableString

    }


    fun resizeDialog(dialog: Dialog) {
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.show()
        dialog.window!!.attributes = lp
    }

    fun checkIsVideoFile(path: String): Boolean {
        var extension = ""
        val i = path.lastIndexOf('.')
        if (i > 0) {
            extension = path.substring(i + 1)
        }
        return extension.equals("MP4", ignoreCase = true)

    }

    fun isEmptyText(view: View?): Boolean {
        return if (view == null)
            true
        else
            getTextValue(view).isEmpty()


    }

    fun getTextValue(view: View): String {
        return (view as? EditText)?.text?.toString()?.trim { it <= ' ' }
            ?: ((view as? TextView)?.text?.toString()?.trim { it <= ' ' }
                ?: "")

    }

    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target)
            .matches()
    }


    fun isValidUser(context: Context): Boolean {
        return if (Pref.getStringValue(
                Pref.PREF_USER_ID,
                "0"
            ).isNullOrEmpty() || Pref.getStringValue(Pref.PREF_USER_ID, "0").equals("0")
        ) {
//            context.startActivity(Intent(context, SignInActivity::class.java))
            ActivityCompat.finishAffinity(context as Activity)
            false
        } else {

            true
        }
    }

//    fun isOnline(context: Context): Boolean {
//        try {
//            val conMgr = context
//                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val info = conMgr.activeNetworkInfo
//            return info != null && info.isConnected
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return false
//        }
//    }
//

    fun openWebIntent(context: Context, url: String) {
        var mUrl = url
        try {
            if (!mUrl.startsWith("http://") && !mUrl.startsWith("https://")) {
                mUrl = "http://$url"
            }

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mUrl))
            context.startActivity(Intent.createChooser(intent, "Choose browser"))


        } catch (e: ActivityNotFoundException) {
            showToastMessage(
                context,
                context.resources.getString(R.string.no_browser_app_available),
                true
            )
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun showToastMessage(context: Context, mgs: String, isShort: Boolean) {
        Toast.makeText(context, mgs, if (isShort) Toast.LENGTH_SHORT else Toast.LENGTH_SHORT).show()
    }


    fun millisToDate(millis: Long, myFormat: String): String {
        return SimpleDateFormat(myFormat, Locale.ENGLISH).format(Date(millis))
    }


    fun millisToDateObj(millis: Long, myFormat: String): Date {
        return SimpleDateFormat(myFormat, Locale.ENGLISH).parse(
            SimpleDateFormat(
                myFormat,
                Locale.ENGLISH
            ).format(Date(millis))
        )
    }

    fun stringToMills(date: String, myFormat: String): Long {
        return convertStringToDate(date, myFormat).time;
    }

    fun convertDateStringToString(
        strDate: String,
        currentFormat: String, parseFormat: String
    ): String {
        return try {
            if (strDate.isNotEmpty() && strDate.isNotBlank())
                convertDateToString(convertStringToDate(strDate, currentFormat), parseFormat)
            else ""
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            ""
        }
    }


    fun convertStringToDate(
        strDate: String,
        parseFormat: String
    ): Date {
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        return SimpleDateFormat(parseFormat, Locale.ENGLISH).parse(strDate)

    }


    private fun convertDateToString(
        objDate: Date, parseFormat: String
    ): String {
        return try {
            SimpleDateFormat(parseFormat, Locale.getDefault()).format(objDate)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            ""
        }
    }


    /* Find index of Sting from String Array*/
//    fun indexOfStringArray(
//        strArray: ArrayList<SpinnerModel>,
//        strFind: String,
//        isName: Boolean
//    ): Int {
//        var index: Int
//        return if (isName) indexOfArray(strArray, strFind) else {
//            index = 0
//            while (index < strArray.size) {
//                if (strArray[index].id == strFind) break
//                index++
//            }
//            if (index >= strArray.size) 0 else index
//        }
//    }
//
//
//    /* Find index of Sting from String Array*/
//
//    private fun indexOfArray(
//        strArray: ArrayList<SpinnerModel>,
//        strFind: String
//    ): Int {
//        var index = 0
//        while (index < strArray.size) {
//            if (strArray[index].name == strFind) break
//            index++
//        }
//        return if (index >= strArray.size) 0 else index
//    }


    fun hideKeyBoard(context: Context, view: View) {
        try {
            val inputMethodManager = context.getSystemService(
                Activity.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun getStringToMillsTime(
        strDateTime: String,
        dateFormat: String,
        isUtc: Boolean
    ): Long {
        return try { //            Log.e("Original Date :", stringTime);
            val formatter: DateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
            if (isUtc)
                formatter.timeZone = (TimeZone.getTimeZone("UTC"))

            val date = formatter.parse(strDateTime)
            date.time
        } catch (e: ParseException) {
            0
        }
    }


    fun resizeFullDailog(
        dialog: Dialog,
        isDialogShow: Boolean
    ) {
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        if (isDialogShow)
            dialog.show()
        dialog.window!!.attributes = lp
    }


//    fun showImagePreview(context: Context, path: String, dummyPic: Int): Dialog {
//        val mediaController: MediaController? = null
//
//        var dialogImage = Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
//        dialogImage.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialogImage.setContentView(R.layout.cust_image_preview_dialog)
//        dialogImage.show()
//
//        var imgProfilePic1: ZoomableImageView = dialogImage.findViewById(R.id.imgProfilePic1)
//        var videoView: VideoView = dialogImage.findViewById(R.id.videoView)
//        var imgCancel: ImageView = dialogImage.findViewById(R.id.imgCancel)
//
//        imgProfilePic1.setActualImageResource(dummyPic)
//        if (path.isNotEmpty()) {
//            if (path.startsWith("http")) {
//                imgProfilePic1.setImageURI(path, context)
//            } else {
//                imgProfilePic1.setImageURI(Uri.fromFile(File(path)), context)
//            }
//        }
//
//        if (path.isNotEmpty() && path.contains(".mp4")) {
//            if (path.startsWith("http")) {
//                videoView.setVideoURI(Uri.parse(path))
//                mediaController?.setAnchorView(videoView)
//                videoView.setMediaController(mediaController)
//                mediaController?.hide()
//                videoView.requestFocus()
//            } else {
//                imgProfilePic1.setImageURI(Uri.fromFile(File(path)), context)
//            }
//        }
//
//        imgCancel.setOnClickListener { dialogImage.dismiss() }
//        return dialogImage
//    }


    fun maskCardNumber(cardNumber: String, mask: String): String? {

        if (cardNumber.isEmpty())
            return ""
        // format the number
        var index = 12
        val maskedNumber = StringBuilder()
        for (element in mask) {
            when (element) {
                '#' -> {
                    maskedNumber.append(cardNumber[index])
                    index++
                }
                'x' -> {
                    maskedNumber.append(element)
                    index++
                }
                else -> {
                    maskedNumber.append(element)
                }
            }
        }

        // return the masked number
        return maskedNumber.toString()
    }


    // Find index of Sting from String Array
//    fun String.priceConverter(): String {
//        return try {
//            String.format(
//                Locale.US,
//                "$PRICE_SIGN%.2f",
//                if (this.isEmpty()) 0f else this.toFloat()
//            )
//        } catch (e: Exception) {
//            e.printStackTrace()
//            String.format(Locale.US, "$PRICE_SIGN%.2f", 0f)
//        }
//
//    }

//    //settoken
//    fun setToken() {
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.w(" Utills ", "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//            // Get new FCM registration token
//            val token = task.result!!
//            Log.d(" Utills  TOKEN::", token.toString())
//            if (!token.equals(
//                    "null",
//                    ignoreCase = true
//                ) && token.isNotEmpty()
//            ) Pref.setStringValue(Pref.PREF_DEVICE_TOKEN, token)
//
//            // Log and toast
//            Log.d(" Utills ", token)
//        })
//
//    }


    fun getDifferanceBetweenTwoDate(todayDate: Date, pastDate: Date): String {
        val diff: Long = todayDate.time - pastDate.time
        var year = 0
        var month = 0
        val MONTH_IN_MILLIS = 2629746000

        if (diff >= MONTH_IN_MILLIS) {
            var totalmonth = (diff / MONTH_IN_MILLIS).toInt()
            year = totalmonth / 12
            month = totalmonth % 12
        }

        return "$year.$month"


    }

//    fun openDatePickerDialog(
//        myDateFormat: String,
//        textView: AppCompatTextView?,
//        context: Context,
//        isFutureDateVisible: Boolean,
//        isPreviousDateVisible: Boolean
//    ) {
//        openDatePickerDialog(
//            myDateFormat,
//            textView,
//            context,
//            isFutureDateVisible,
//            isPreviousDateVisible,
//            System.currentTimeMillis(),
//            System.currentTimeMillis(),
//            null,
//            false
//        )
//    }
//
//    private fun openDatePickerDialog(
//        myDateFormat: String,
//        textView: AppCompatTextView?,
//        context: Context,
//        isFutureDateVisible: Boolean,
//        isPreviousDateVisible: Boolean,
//        MaxDateTime: Long,
//        minDate: Long,
//        responseListener: ResponseListener?,
//        isTimePickerShow: Boolean
//    ) {
//
//        val cal = Calendar.getInstance()
//        var years: Int = cal.get(Calendar.YEAR)
//        var months: Int = cal.get(Calendar.MONTH)
//        var days: Int = cal.get(Calendar.DAY_OF_MONTH)
//
//        if (textView != null && !isEmptyText(textView)) {
//
//            var newValue =
//                convertDateStringToString(getTextValue(textView), myDateFormat, "yyyy/MM/dd")
//            if (newValue.contains("/")) {
//                val lstValues: List<String> = newValue.split("/")
//                years = Integer.parseInt(lstValues[0])
//                months = Integer.parseInt(lstValues[1]) - 1
//                days = Integer.parseInt(lstValues[2])
//
//
//            }
//        }
//        val datePicker = DatePickerDialog(
//            context,
//            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
////                if (isTimePickerShow)
////                    timePicker(cal, context, textView, responseListener, myDateFormat)
//                if (textView != null) {
//                    textView.text = convertDateToString(cal.time, myDateFormat)
//
//                    responseListener?.onResponse(
//                        DATE_TIME_CHANGE,
//                        SUCCESS,
//                        null
//                    )
//                }
//            },
//            // set DatePickerDialog to point to today's date when it loads up
//            years,
//            months,
//            days
//        )
//        if (!isFutureDateVisible)
//            datePicker.datePicker.maxDate = (MaxDateTime)
//        datePicker.show()
//
//        if (!isPreviousDateVisible)
//            datePicker.datePicker.minDate = (minDate)
//        datePicker.show()
//
//
//
//
//    }


    /*fun timePicker(
        calendar: Calendar,
        context: Context?,
        timeView: TextView?,
        responseListener: ResponseListener?, myDateFormat: String
    ) {
        val mHours = calendar[Calendar.HOUR_OF_DAY]
        val mMinute = calendar[Calendar.MINUTE]
        @SuppressLint("SetTextI18n") val timePicker =
            TimePickerDialog(
                context, AlertDialog.THEME_HOLO_LIGHT,
                TimePickerDialog.OnTimeSetListener { _: TimePicker?, hourOfDay: Int, minute: Int ->

                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minute)

                    if (timeView != null)
                        timeView.text = convertDateToString(calendar.time, myDateFormat)

                    responseListener?.onResponse(
                        DATE_TIME_CHANGE,
                        SUCCESS,
                        null
                    )
                }, mHours, mMinute, false
            )
        timePicker.show()
    }
*/

}