package com.example.profilecardlayout

import android.content.Context

data class UserProfile(val id: Int, val name: String, val status:Boolean, val drawableid: String)

//     val userprofilelist= arrayListOf<UserProfile>(
//         UserProfile(name="John", status=true,drawableid= R.drawable.profilecard_image2),
//                 UserProfile(name="Kat", status=false,drawableid= R.drawable.profilecard_image),
//                         UserProfile(name="John", status=true,drawableid= R.drawable.profilecard_image2),
//UserProfile(name="Kat", status=false,drawableid= R.drawable.profilecard_image),
//UserProfile(name="John", status=true,drawableid= R.drawable.profilecard_image2),
//UserProfile(name="Kat", status=false,drawableid= R.drawable.profilecard_image),
//UserProfile(name="John", status=true,drawableid= R.drawable.profilecard_image2),
//UserProfile(name="Kat", status=false,drawableid= R.drawable.profilecard_image),
//UserProfile(name="John", status=true,drawableid= R.drawable.profilecard_image2),
//UserProfile(name="Kat", status=false,drawableid= R.drawable.profilecard_image)

val userprofileList = arrayListOf(
    UserProfile(
        id=0,
        name = "Michaela Runnings",
        status = true,
        "https://images.unsplash.com/photo-1485290334039-a3c69043e517?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80"
    ),
    UserProfile(
        id=1,
        name = "John Pestridge",
        status = false,
        "https://images.unsplash.com/photo-1542178243-bc20204b769f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTB8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        id=2,
        name = "Manilla Andrews",
        status = true,
        "https://images.unsplash.com/photo-1543123820-ac4a5f77da38?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDh8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        id=3,
        name = "Dan Spicer",
        status = false,
        "https://images.unsplash.com/photo-1595152772835-219674b2a8a6?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDd8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        id=4,
        name = "Keanu Dester",
        status = false,
        "https://images.unsplash.com/photo-1597528380214-aa94bde3fc32?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NTZ8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        id=5,
        name = "Anichu Patel",
        status = false,
        "https://images.unsplash.com/photo-1598641795816-a84ac9eac40c?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NjJ8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        id=6,
        name = "Kienla Onso",
        status = true,
        "https://images.unsplash.com/photo-1566895733044-d2bdda8b6234?ixid=MXwxMjA3fDB8MHxzZWFyY2h8ODh8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        id=7,
        name = "Andra Matthews",
        status = false,
        "https://images.unsplash.com/photo-1530577197743-7adf14294584?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NTV8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),



     )
