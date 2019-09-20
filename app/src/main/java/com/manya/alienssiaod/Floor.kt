package com.manya.alienssiaod

data class Floor(
    val name : String,
    val color : Int,
    val rooms :Array<String>

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Floor

        if (name != other.name) return false
        if (color != other.color) return false
        if (!rooms.contentEquals(other.rooms)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + color
        result = 31 * result + rooms.contentHashCode()
        return result
    }
}