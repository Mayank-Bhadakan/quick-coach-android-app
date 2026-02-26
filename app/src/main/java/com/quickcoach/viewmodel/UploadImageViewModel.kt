package com.quickcoach.viewmodel

import android.content.Context
import android.util.Log
import com.quickcoach.R
import com.quickcoach.utils.Util
import java.io.File

class UploadImageViewModel
{
    companion object {
        val shared: UploadImageViewModel = UploadImageViewModel()
    }

    //    val uploadResponse: MutableLiveData<String> = MutableLiveData()
////    fun uploadWithTransferUtility(
////        context: Context,
////        filePath: String,
////        onComplete: ((String) -> Unit)? = null
////    ) {
////        if (!Util.isOnline(context)) {
////            Util.showToastMessage(
////                context,
////                context.resources.getString(R.string.checkInternet),
////                false
////            )
////            return
////        }
//
//        Util.run { showProgress(context) }

//    TransferNetworkLossHandler.getInstance(Context)
//
//        val transferUtility = builder().s3Client(
//            AmazonS3Client(
//                CognitoCachingCredentialsProvider(
//                    context.applicationContext,
//                    COGNITO_POOL_ID,
//                    Regions.fromName(BUCKET_REGION)
//                ),
//                Region.getRegion(Regions.fromName(BUCKET_REGION))
//            )
//        )
//            .context(context.applicationContext).build()
//
//        if (!File(filePath).exists()) {
//            Util.dismissProgress()
//            Util.showToastMessage(context, "Could not find the filepath of the selected file", true)
//            return
//        }
//
//        val isVideo = Util.checkIsVideoFile(filePath)
//        val time = System.currentTimeMillis()
//        val fileName: String =
//            if (isVideo) "$BUCKET_FOLDER_NAME/android_$time.mp4" else "$BUCKET_FOLDER_NAME/android_$time.png"
//
//        val url = "https://s3.$BUCKET_REGION.amazonaws.com/$BUCKET_NAME/$fileName"
//
//        val observer: TransferObserver =
//            transferUtility.upload(BUCKET_NAME, fileName, File(filePath))
////        val uploadObserver = transferUtility.upload("s3folder/s3key.txt", File("/path/to/localfile.txt"))
//
//        Util.print("url >>>>" + url)
//        // Attach a listener to the observer
//        observer.setTransferListener(object : TransferListener {
//            override fun onStateChanged(id: Int, state: TransferState) {
//
//                Log.d("", "UPLOAD - - ID: $id, STATE CHANGE  = $state")
//
//                if (state == TransferState.COMPLETED) {
//                    // Handle a completed upload
//                    Util.dismissProgress()
////                    uploadResponse.postValue(url)
//                    onComplete?.invoke(url)
//                }
//            }
//
//            override fun onProgressChanged(id: Int, current: Long, total: Long) {
//                val done = (((current.toDouble() / total) * 100.0).toInt())
//                Log.d("", "UPLOAD - - ID: $id, percent done = $done")
//            }
//
//            override fun onError(id: Int, ex: Exception) {
//                Util.dismissProgress()
//                Log.d("", "UPLOAD ERROR - - ID: $id - - EX: ${ex.message.toString()}")
//            }
//        })
//        // If you prefer to long-poll for updates
//        /*        if (observer.state == TransferState.COMPLETED) {
//            *//* Handle completion *//*
//        }
//
//        val bytesTransferred = observer.bytesTransferred*/
    }
