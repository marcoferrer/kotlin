/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.codegen.range.comparison

import org.jetbrains.org.objectweb.asm.Label
import org.jetbrains.org.objectweb.asm.Type
import org.jetbrains.org.objectweb.asm.commons.InstructionAdapter

class UnsignedIntegerComparisonGenerator(
    override val comparedType: Type,
    private val compareMethodName: String,
    private val compareMethodDescriptor: String
) : ComparisonGenerator {
    override fun jumpIfGreaterOrEqual(v: InstructionAdapter, label: Label) {
        v.invokestatic("kotlin/UnsignedKt", compareMethodName, compareMethodDescriptor, false)
        v.ifge(label)
    }

    override fun jumpIfLessOrEqual(v: InstructionAdapter, label: Label) {
        v.invokestatic("kotlin/UnsignedKt", compareMethodName, compareMethodDescriptor, false)
        v.ifle(label)
    }

    override fun jumpIfGreater(v: InstructionAdapter, label: Label) {
        v.invokestatic("kotlin/UnsignedKt", compareMethodName, compareMethodDescriptor, false)
        v.ifgt(label)
    }

    override fun jumpIfLess(v: InstructionAdapter, label: Label) {
        v.invokestatic("kotlin/UnsignedKt", compareMethodName, compareMethodDescriptor, false)
        v.iflt(label)
    }
}

val UIntComparisonGenerator = UnsignedIntegerComparisonGenerator(Type.INT_TYPE, "uintCompare", "(II)I")
val ULongComparisonGenerator = UnsignedIntegerComparisonGenerator(Type.LONG_TYPE, "ulongCompare", "(JJ)I")