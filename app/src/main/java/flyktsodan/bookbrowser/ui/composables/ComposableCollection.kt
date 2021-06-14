package flyktsodan.bookbrowser.ui.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import flyktsodan.bookbrowser.decorations.Decoration
import flyktsodan.bookbrowser.inspiration.Book
import flyktsodan.bookbrowser.inspiration.availableBooks
import flyktsodan.bookbrowser.ui.theme.ComposePlaygroundTheme

@Composable
fun Error(onRetryClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { onRetryClicked() }) {
            Text(text = "ERROR - try again")
        }
    }
}

@Composable
fun Loader() {
    Text("Loading..")
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BookListRow(
    book: Book = availableBooks[0],
    decorations: Decoration = Decoration(false),
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .width(160.dp)
            .height(240.dp)
            .padding(8.dp),
        elevation = 8.dp,
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .absolutePadding(left = 8.dp, right = 8.dp, top = 8.dp)
            ) {
                Image(
                    painter = rememberCoilPainter(
                        request = book.imageUrl,
                        fadeIn = true,
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .height(160.dp)
                        .background(color = Color.Gray),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "BADGES",
                    Modifier
                        .align(Alignment.BottomCenter)
                        .background(MaterialTheme.colors.surface.copy(alpha = 0.5f))
                )
                if (decorations.isRead) {
                    Box(
                        Modifier
                            .align(Alignment.Center)
                            .background(color = Color.Green.copy(alpha = 0.7f), shape = CircleShape)
                            .width(50.dp)
                            .height(50.dp)
                    ) {
                        Text(text = "✔️", modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = book.title, fontWeight = FontWeight.Bold, fontSize = 16.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(text = book.author, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        BookListRow()
    }
}