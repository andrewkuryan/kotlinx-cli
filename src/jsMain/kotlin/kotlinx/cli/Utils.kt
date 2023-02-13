/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

package kotlinx.cli

@JsModule("process")
@JsNonModule
external object Process {
    fun exit(code: Int): Nothing
}

internal actual fun exitProcess(status: Int): Nothing {
    Process.exit(0)
}