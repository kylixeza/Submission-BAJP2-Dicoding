package com.kylix.submissionbajp2

import com.kylix.submissionbajp2.model.repository.remote.ItemList
import com.kylix.submissionbajp2.model.repository.remote.TvShowDetail

object FakeData {
    fun getDummyRemoteMovie(): List<ItemList> =
        arrayListOf(
            ItemList(
                590706,
                "/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                "/jeAQdDX9nguP6YOX6QSWKDPkbBo.jpg",
                "Jiu Jitsu",
                "From the darkness, the ultimate fighter rises.",
                "Every six years, an ancient order of jiu-jitsu fighters joins forces to " +
                        "battle a vicious race of alien invaders. But when a celebrated war hero goes " +
                        "down in defeat, the fate of the planet and mankind hangs in the balance.",
                "2020-11-20",
                5.7,
                ""),
            ItemList(1, "", "", "", "", "", "", 0.0, ""),
            ItemList(2, "", "", "", "", "", "", 0.0, ""),
            ItemList(3, "", "", "", "", "", "", 0.0, ""),
            ItemList(4, "", "", "", "", "", "", 0.0, ""),
            ItemList(5, "", "", "", "", "", "", 0.0, ""),
            ItemList(6, "", "", "", "", "", "", 0.0, ""),
            ItemList(7, "", "", "", "", "", "", 0.0, ""),
            ItemList(8, "", "", "", "", "", "", 0.0, ""),
            ItemList(9, "", "", "", "", "", "", 0.0, ""),
            ItemList(10, "", "", "", "", "", "", 0.0, ""),
            ItemList(11, "", "", "", "", "", "", 0.0, ""),
            ItemList(12, "", "", "", "", "", "", 0.0, ""),
            ItemList(13, "", "", "", "", "", "", 0.0, ""),
            ItemList(14, "", "", "", "", "", "", 0.0, ""),
            ItemList(15, "", "", "", "", "", "", 0.0, ""),
            ItemList(16, "", "", "", "", "", "", 0.0, ""),
            ItemList(17, "", "", "", "", "", "", 0.0, ""),
            ItemList(18, "", "", "", "", "", "", 0.0, ""),
            ItemList(19, "", "", "", "", "", "", 0.0, "")
        )


    fun getDummyRemoteTvShows(): List<ItemList> =
        arrayListOf(
            ItemList(
                82856,
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "/9ijMGlJKqcslswWUzTEwScm82Gs.jpg",
                "",
                "",
                "After the fall of the Galactic Empire, lawlessness has spread throughout " +
                        "the galaxy. A lone gunfighter makes his way through the outer reaches, earning " +
                        "his keep as a bounty hunter.",
                "",
                8.5,
                "The Mandalorian"
            ),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, ""),
            ItemList(0, "", "", "", "", "", "", 0.0, "")
        )

    fun getTvShowDetail(): TvShowDetail =
        TvShowDetail(82856,
            "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
            "/9ijMGlJKqcslswWUzTEwScm82Gs.jpg",
            "The Mandalorian",
            "The Mandalorian",
            "2019-11-12",
            "After the fall of the Galactic Empire, lawlessness has spread throughout the " +
                    "galaxy. A lone gunfighter makes his way through the outer reaches, earning his " +
                    "keep as a bounty hunter.",
            8.5
        )
}