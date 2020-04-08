@file:Suppress("HasPlatformType", "unused")

package de.hkokocin.testkit

import com.google.common.collect.*
import com.google.common.truth.Truth
import com.google.common.util.concurrent.AtomicLongMap
import java.math.BigDecimal
import java.util.*

fun <T : Comparable<*>> assertThat(actual: T?) = Truth.assertThat(actual)
fun assertThat(actual: Any?) = Truth.assertThat(actual)
fun assertThat(actual: Byte?) = Truth.assertThat(actual)
fun assertThat(actual: Int?) = Truth.assertThat(actual)
fun assertThat(actual: Long?) = Truth.assertThat(actual)
fun assertThat(actual: Char?) = Truth.assertThat(actual)
fun assertThat(actual: Float?) = Truth.assertThat(actual)
fun assertThat(actual: Double?) = Truth.assertThat(actual)
fun assertThat(actual: Short?) = Truth.assertThat(actual)
fun assertThat(actual: Boolean?) = Truth.assertThat(actual)
fun assertThat(actual: String?) = Truth.assertThat(actual)
fun assertThat(actual: Class<*>?) = Truth.assertThat(actual)
fun assertThat(actual: ByteArray?) = Truth.assertThat(actual)
fun assertThat(actual: IntArray?) = Truth.assertThat(actual)
fun assertThat(actual: LongArray?) = Truth.assertThat(actual)
fun assertThat(actual: CharArray?) = Truth.assertThat(actual)
fun assertThat(actual: FloatArray?) = Truth.assertThat(actual)
fun assertThat(actual: DoubleArray?) = Truth.assertThat(actual)
fun assertThat(actual: ShortArray?) = Truth.assertThat(actual)
fun assertThat(actual: BooleanArray?) = Truth.assertThat(actual)
fun assertThat(actual: Throwable?) = Truth.assertThat(actual)
fun assertThat(actual: BigDecimal?) = Truth.assertThat(actual)
fun assertThat(actual: Multiset<*>?) = Truth.assertThat(actual)
fun assertThat(actual: Optional<*>?) = Truth.assertThat(actual)
fun assertThat(actual: SortedSet<*>?) = Truth.assertThat(actual)
fun assertThat(actual: Multimap<*, *>?) = Truth.assertThat(actual)
fun assertThat(actual: Table<*, *, *>?) = Truth.assertThat(actual)
fun <T> assertThat(actual: Array<out T>?) = Truth.assertThat(actual)
fun assertThat(actual: SortedMap<*, *>?) = Truth.assertThat(actual)
fun assertThat(actual: AtomicLongMap<*>?) = Truth.assertThat(actual)
fun assertThat(actual: SetMultimap<*, *>?) = Truth.assertThat(actual)
fun assertThat(actual: Map<*, *>?) = Truth.assertThat(actual)
fun assertThat(actual: ListMultimap<*, *>?) = Truth.assertThat(actual)
fun assertThat(actual: Iterable<*>?) = Truth.assertThat(actual)
