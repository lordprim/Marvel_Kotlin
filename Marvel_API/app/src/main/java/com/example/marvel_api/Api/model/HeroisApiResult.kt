package com.example.marvel_api.Api.model

import android.os.Parcel
import android.os.Parcelable

data class HeroisApiResult(
    val data: HeroiData
)

data class HeroiData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<HeroiResult>
)

data class HeroiResult(
    val name: String?,
    val thumbnail: HeroiScreen?,
    val comics: HeroiComics?,
    val series: HeroiSeries?,
    val stories: HeroiStories?,
    val events: HeroiEvents?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(HeroiScreen::class.java.classLoader),
        parcel.readParcelable(HeroiComics::class.java.classLoader),
        parcel.readParcelable(HeroiSeries::class.java.classLoader),
        parcel.readParcelable(HeroiStories::class.java.classLoader),
        parcel.readParcelable(HeroiEvents::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(thumbnail, flags)
        parcel.writeParcelable(comics, flags)
        parcel.writeParcelable(series, flags)
        parcel.writeParcelable(stories, flags)
        parcel.writeParcelable(events, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroiResult> {
        override fun createFromParcel(parcel: Parcel): HeroiResult {
            return HeroiResult(parcel)
        }

        override fun newArray(size: Int): Array<HeroiResult?> {
            return arrayOfNulls(size)
        }
    }
}

data class HeroiScreen(
    val path: String?,
    val extension: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(path)
        parcel.writeString(extension)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroiScreen> {
        override fun createFromParcel(parcel: Parcel): HeroiScreen {
            return HeroiScreen(parcel)
        }

        override fun newArray(size: Int): Array<HeroiScreen?> {
            return arrayOfNulls(size)
        }
    }
}

data class HeroiComics(
    val available: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(available)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroiComics> {
        override fun createFromParcel(parcel: Parcel): HeroiComics {
            return HeroiComics(parcel)
        }

        override fun newArray(size: Int): Array<HeroiComics?> {
            return arrayOfNulls(size)
        }
    }
}

data class HeroiSeries(
    val available: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(available)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroiSeries> {
        override fun createFromParcel(parcel: Parcel): HeroiSeries {
            return HeroiSeries(parcel)
        }

        override fun newArray(size: Int): Array<HeroiSeries?> {
            return arrayOfNulls(size)
        }
    }
}

data class HeroiStories(
    val available: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(available)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroiStories> {
        override fun createFromParcel(parcel: Parcel): HeroiStories {
            return HeroiStories(parcel)
        }

        override fun newArray(size: Int): Array<HeroiStories?> {
            return arrayOfNulls(size)
        }
    }
}

data class HeroiEvents(
    val events: Int?,
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(events)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeroiEvents> {
        override fun createFromParcel(parcel: Parcel): HeroiEvents {
            return HeroiEvents(parcel)
        }

        override fun newArray(size: Int): Array<HeroiEvents?> {
            return arrayOfNulls(size)
        }
    }
}