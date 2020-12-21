package omari.hamza.storyviewdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import omari.hamza.storyview.StoryView;
import omari.hamza.storyview.callback.OnStoryChangedCallback;
import omari.hamza.storyview.callback.StoryClickListeners;
import omari.hamza.storyview.model.MyStory;
import omari.hamza.storyviewdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setActivity(this);
    }

    public void showStories() {

        final ArrayList<MyStory> myStories = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        try {
            MyStory story1 = new MyStory("https://media.pri.org/s3fs-public/styles/story_main/public/images/2019/09/092419-germany-climate.jpg?itok=P3FbPOp-", simpleDateFormat.parse("20-10-2019 10:00:00"));
            story1.setBottomDescription("This is a description");
            story1.setBottomHashTag("#foodLover #foodKing #tiktok #kashfia");
            story1.setBottomPicUrl("https://imgproxy.epicpxls.com/NRZylOO5W_8JMKggERaZHnMHDhRpjqaRXkRryjdvgxg/rs:fill:409:307:0/g:no/aHR0cHM6Ly9pdGVt/cy5lcGljcHhscy5j/b20vdXBsb2Fkcy9w/aG90by9lYTQ5ZGYy/ODI4MGRkYWI2ZjYw/ZDg3ZTlmYzdkYTlm/Ng.jpg");
            story1.setBottomTitle("Mr. Restaurant");
            story1.setBottomSubtitle("52/4, Dhaka, Bangladesh");
            myStories.add(story1);

            MyStory story2 = new MyStory("https://imgproxy.epicpxls.com/NRZylOO5W_8JMKggERaZHnMHDhRpjqaRXkRryjdvgxg/rs:fill:409:307:0/g:no/aHR0cHM6Ly9pdGVt/cy5lcGljcHhscy5j/b20vdXBsb2Fkcy9w/aG90by9lYTQ5ZGYy/ODI4MGRkYWI2ZjYw/ZDg3ZTlmYzdkYTlm/Ng.jpg", simpleDateFormat.parse("26-10-2019 15:00:00"));
            story2.setBottomDescription("This is a description");
            story2.setBottomHashTag("#foodLover #foodKing #tiktok #kashfia");
            story2.setBottomPicUrl("https://imgproxy.epicpxls.com/NRZylOO5W_8JMKggERaZHnMHDhRpjqaRXkRryjdvgxg/rs:fill:409:307:0/g:no/aHR0cHM6Ly9pdGVt/cy5lcGljcHhscy5j/b20vdXBsb2Fkcy9w/aG90by9lYTQ5ZGYy/ODI4MGRkYWI2ZjYw/ZDg3ZTlmYzdkYTlm/Ng.jpg");
            story2.setBottomTitle("Mr. Restaurant");
            story2.setBottomSubtitle("52/4, Dhaka, Bangladesh");
            myStories.add(story2);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        new StoryView.Builder(getSupportFragmentManager())
                .setStoriesList(myStories)
                .setStoryDuration(5000)
                .setTitleText("Hamza Al-Omari")
                .setSubtitleText("Damascus")
                .setStoryClickListeners(new StoryClickListeners() {
                    @Override
                    public void onDescriptionClickListener(int position) {
                        Toast.makeText(MainActivity.this, "Clicked: " + myStories.get(position).getBottomDescription(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onTitleIconClickListener(int position) {
                    }
                })
                .setOnStoryChangedCallback(position -> Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show())
                .setStartingIndex(0)
                .setRtl(true)
                .build()
                .show();

    }
}
