package com.batdemir.similar.flora.example.model

data class DynamicFilterValuesModel(
    val count: Long,
    val id: Long,
    val selected: Boolean,
    val link: String,
    val name: String,
    val group: Int,
    val detailValueId: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DynamicFilterValuesModel

        if (id != other.id) return false
        if (link != other.link) return false
        if (name != other.name) return false
        if (group != other.group) return false
        if (detailValueId != other.detailValueId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + link.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + group
        result = 31 * result + detailValueId.hashCode()
        return result
    }
}