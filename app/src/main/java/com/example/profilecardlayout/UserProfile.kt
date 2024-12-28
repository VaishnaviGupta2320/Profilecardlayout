package com.example.profilecardlayout

data class UserProfile constructor(val name: String, val status:Boolean, val drawableid:Int)

     val userprofilelist= arrayListOf<UserProfile>(
         UserProfile(name="John", status=true,drawableid= R.drawable.profilecard_image2),
                 UserProfile(name="Kat", status=false,drawableid= R.drawable.profilecard_image)
     )
