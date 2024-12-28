package com.example.profilecardlayout
import android.annotation.SuppressLint
import android.graphics.drawable.Icon
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecardlayout.ui.theme.MyTheme
//import androidx.compose.ui.unit.dp as
import androidx.compose.ui.unit.dp


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
    fun MainScreen(userProfiles: List<UserProfile> = userprofilelist) {
        Scaffold(topBar = {AppBar()})
        {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray)
            {
                Column() {
                    for (userprofile in userProfiles)
                    ProfileCard(userProfile=userprofile)

                }

            }
        }

    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 50.dp)) {
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
            modifier = Modifier.padding(8.dp, 80.dp, 16.dp, 16.dp).fillMaxWidth()
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
    fun ProfilePhoto(drawableid :Int, onlinestatus:Boolean) {
        Card(
            shape = CircleShape,
            border = BorderStroke(width = 2.dp, color=
            if(onlinestatus) (Color.Green)
                else Color.Red),
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        )
        {

            Image(
                painter = painterResource(id = drawableid),
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Content Description",

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

