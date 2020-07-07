/* ktlint-disable max-line-length */
package com.azimolabs.conditionwatcher

private const val CONDITION_NOT_MET = 0
private const val CONDITION_MET = 1
private const val TIMEOUT = 2
private const val DEFAULT_TIMEOUT_LIMIT = 1000 * 60L
private const val DEFAULT_INTERVAL = 250L

@Throws(Exception::class)
fun waitForCondition(
    watchInterval: Long = DEFAULT_INTERVAL,
    timeoutLimit: Long = DEFAULT_TIMEOUT_LIMIT,
    instruction: () -> Unit
) {
    var status = CONDITION_NOT_MET
    var elapsedTime = 0L
    do {
        try {
            instruction()
            status = CONDITION_MET
        } catch (error: Throwable) {
            elapsedTime += watchInterval
            Thread.sleep(watchInterval)
        }
        if (elapsedTime >= timeoutLimit) {
            status = TIMEOUT
            break
        }
    } while (status != CONDITION_MET)
    if (status == TIMEOUT)
        throw Exception("Instruction - took more than $timeoutLimit milliseconds. Test stopped.")
}
