package com.example.profilecardlayout
//import androidx.compose.ui.unit.dp as

//import coil.compose.rememberAsyncImagePainter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.profilecardlayout.ui.theme.MyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                MainScreen()
            }
        }
        }
    }


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainScreen(userProfiles: List<UserProfile> = userprofileList) {
        Scaffold(topBar = {AppBar()})
        {
            Surface(modifier = Modifier.fillMaxSize().padding(0.dp,65.dp,0.dp,0.dp),
                color = Color.LightGray)
            {
                LazyColumn {
                    items(userProfiles)
                    { userprofile->userprofile
                        ProfileCard(userProfile=userprofile)
                    }
                }

            }
        }

    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 0.dp)) {
        TopAppBar(
            navigationIcon = {
                Icon(
                    Icons.Default.Home,
                    modifier = Modifier.padding(horizontal = 14.dp),
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
    fun ProfileCard(userProfile: UserProfile) {

        Card(
            modifier = Modifier.padding(8.dp, 10.dp, 16.dp, 16.dp).fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top),
            shape =  CutCornerShape(0,25),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfilePhoto(userProfile.drawableid, userProfile.status)
                ProfileContent(userProfile.name, userProfile.status)
            }

        }
    }

    @Composable
    fun ProfilePhoto(drawableid: String, onlinestatus:Boolean) {

        Card(
            shape = CircleShape,
            border = BorderStroke(width = 2.dp, color=
            if(onlinestatus) (Color.Green)
                else Color.Red),
            modifier = Modifier.padding(16.dp),
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
                modifier = Modifier.size(72.dp),
                contentDescription = "Profile picture description",
            )

            
        }
    }

    @Composable
    fun ProfileContent(name: String, onlinestatus: Boolean) {
        Column(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
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
    fun GreetingPreview() {
        MyTheme {
            MainScreen()
        }


    }

