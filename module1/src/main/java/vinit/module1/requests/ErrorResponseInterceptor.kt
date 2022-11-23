package com.signify.indoor_navigation.site_enabler.requests

import okhttp3.Interceptor
import okhttp3.Response
import okio.GzipSource
import java.nio.charset.Charset

class ErrorResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val code = response.code()
        if (code in 400..500) {
            responseBody(response)?.also { errorString ->
                // error string here is a body of server error
            }
        }
        return response
    }

    private fun responseBody(response: Response): String? {
        val responseBody = response.body() ?: return null
        val contentLength = responseBody.contentLength()

        if (contentLength == 0L) {
            return null
        }

        val source = responseBody.source()
        source.request(Long.MAX_VALUE) // Buffer the entire body.
        var buffer = source.buffer()
        val headers = response.headers()

        if ("gzip".equals(headers.get("Content-Encoding"), ignoreCase = true)) {
            var gzippedResponseBody: GzipSource? = null
            try {
                gzippedResponseBody = GzipSource(buffer.clone())
                buffer = okio.Buffer()
                buffer.writeAll(gzippedResponseBody)
            } finally {
                gzippedResponseBody?.close()
            }
        }

        val charset: Charset = responseBody.contentType()?.charset(UTF8) ?: UTF8
        return buffer.clone().readString(charset)
    }

    private companion object {
        val UTF8: Charset = Charset.forName("UTF-8")
    }
}