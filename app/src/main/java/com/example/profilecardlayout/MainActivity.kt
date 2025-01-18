package com.example.profilecardlayout
//import androidx.compose.ui.unit.dp as

//import coil.compose.rememberAsyncImagePainter
import android.annotation.SuppressLint
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.profilecardlayout.ui.theme.MyTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                //MainScreen()
                UserApplication()
            }
        }
        }
    }

@Composable
fun UserApplication(userProfiles: List<UserProfile> = userprofileList)
{
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = "user_list")
    {
        composable(route = "user_list")

        {
            MainScreen(userProfiles, navController)
        }
        composable(route = "user_details/{user_id}",
            arguments = listOf(navArgument("user_id")
            {
                type=NavType.IntType
            }))
        {
            navBackStackEntry->
            UserProfileDetailScreen(navBackStackEntry.arguments!!.getInt("user_id"), navController)
        }
    }
}


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainScreen(userProfiles: List<UserProfile>, navController: NavHostController?) {
        Scaffold(topBar = {AppBar(title = "User_list",
            icon = Icons.Default.Home)
        {}
        })
        {
            Surface(modifier = Modifier.fillMaxSize().padding(0.dp,65.dp,0.dp,0.dp),
                color = Color.LightGray)
            {
                LazyColumn {
                    items(userProfiles)
                    { userprofile->userprofile
                        ProfileCard(userProfile=userprofile)
                        {
                            navController?.navigate("user_details/${userprofile.id}")
                        }
                    }
                }

            }
        }

    }
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserProfileDetailScreen(user_id: Int, navController: NavHostController?)
{
    val userProfiles = userprofileList.first{ userProfile -> user_id== userProfile.id }
    Scaffold(topBar = {AppBar(title = "User detail list",
        icon = Icons.AutoMirrored.Filled.ArrowBack)
    {
navController?.navigateUp()
    }
    })
    {
        Surface(modifier = Modifier.fillMaxSize().padding(0.dp,65.dp,0.dp,0.dp),
            color = Color.LightGray)
            {

            //ProfileCard(userProfile=userProfiles)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                ProfilePhoto(userProfiles.drawableid, userProfiles.status, 240.dp)
                ProfileContent(userProfiles.name, userProfiles.status, Alignment.CenterHorizontally)
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title:String, icon:ImageVector, iconClickAction: ()-> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 0.dp)) {
        TopAppBar(
            navigationIcon = {
                Icon(
                    //Icons.Default.Home,
                    icon,
                    modifier = Modifier.padding(horizontal = 14.dp).
                    clickable(onClick =  { iconClickAction.invoke() }),
                    contentDescription = "Home"
                )
            },
            title = {
                Text("Messaging Application user")
            },

            colors = TopAppBarColors(Color.Blue, Color.White, Color.White, Color.White, Color.White)
        )
    }
}

    @Composable
    fun ProfileCard(userProfile: UserProfile, clickAction: ()-> Unit) {

        Card(
            modifier = Modifier.padding(8.dp, 10.dp, 16.dp, 16.dp).fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top).clickable { clickAction.invoke() },
            shape =  CutCornerShape(0,25),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfilePhoto(userProfile.drawableid, userProfile.status, 72.dp)
                ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
            }

        }
    }

    @Composable
    fun ProfilePhoto(drawableid: String, onlinestatus:Boolean, imageSize:Dp) {

        Card(
            shape = CircleShape,
            border = BorderStroke(width = 2.dp, color=
            if(onlinestatus) (Color.Green)
                else Color.Red),
            modifier = Modifier.padding(16.dp).size(imageSize),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        )
        {



//            Image(
//                painter = painter,
//                modifier = Modifier.size(72.dp),
//                contentDescription = "Profile picture"
//            )
//            Image(
//                painter = painterResource(id=drawableid),
//                modifier = Modifier.size(100.dp),
//                contentScale = ContentScale.Crop,
//                contentDescription = "Content Description",
//            )
            Image(
                painter = rememberImagePainter(
                    data = drawableid,
                ),
                modifier = Modifier.size(240.dp),
                contentDescription = "Profile picture description",
            )

            
        }
    }

    @Composable
    fun ProfileContent(name: String, onlinestatus: Boolean, alignment: Alignment.Horizontal) {
        Column(modifier = Modifier.padding(8.dp),
            horizontalAlignment = alignment) {
            Text(name, style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold )
            CompositionLocalProvider(LocalContentColor provides Color.Gray) {
                Text(if (onlinestatus)"Active Now"
                else "Offline"
                    , style = MaterialTheme.typography.bodyLarge)
            }

        }

    }



@Preview(showBackground = true)
@Composable
fun UserProfileDetailsPreview() {
    MyTheme {
        UserProfileDetailScreen(user_id = 0, null)
    }


}




    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyTheme {
            MainScreen(userProfiles = userprofileList, null)
        }


    }

