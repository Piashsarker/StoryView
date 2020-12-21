package omari.hamza.storyview.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import omari.hamza.storyview.R;
import omari.hamza.storyview.callback.StoryCallbacks;
import omari.hamza.storyview.model.MyStory;

public class ViewPagerAdapter extends PagerAdapter {

    private final ArrayList<MyStory> images;
    private final Context context;
    private final StoryCallbacks storyCallbacks;
    private boolean storiesStarted = false;

    public ViewPagerAdapter(ArrayList<MyStory> images, Context context, StoryCallbacks storyCallbacks) {
        this.images = images;
        this.context = context;
        this.storyCallbacks = storyCallbacks;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, final int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        MyStory currentStory = images.get(position);
        final View view = inflater.inflate(R.layout.layout_story_item, collection, false);
        final ImageView mImageView = view.findViewById(R.id.mImageView);
        final TextView txtBottomHashTag = view.findViewById(R.id.txtBottomHashTag);
        final TextView txtBottomTitle = view.findViewById(R.id.txtBottomTitle);
        final TextView txtBottomSubtitle = view.findViewById(R.id.txtBottomSubTitle);
        final TextView txtBottomDescription = view.findViewById(R.id.txtBottomDescription);
        final ImageView imgBottom = view.findViewById(R.id.imgLayoutBottom);
        final ConstraintLayout bottomLayout = view.findViewById(R.id.layoutBottom);

        if (!TextUtils.isEmpty(currentStory.getBottomDescription())) {
            txtBottomDescription.setText(currentStory.getBottomDescription());
        }

        if (!TextUtils.isEmpty(currentStory.getBottomTitle())) {
            txtBottomTitle.setText(currentStory.getBottomTitle());
        }
        if (!TextUtils.isEmpty(currentStory.getBottomHashTag())) {
            txtBottomHashTag.setText(currentStory.getBottomHashTag());
        }
        if (!TextUtils.isEmpty(currentStory.getBottomSubtitle())) {
            txtBottomSubtitle.setText(currentStory.getBottomSubtitle());
        }
        if (!TextUtils.isEmpty(currentStory.getBottomPicUrl())) {
            Glide.with(context).load(currentStory.getBottomPicUrl()).into(imgBottom);
        }
        bottomLayout.setOnClickListener(view1 -> {
            storyCallbacks.onDescriptionClickListener(position);
        });


        Glide.with(context)
                .load(currentStory.getUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        storyCallbacks.nextStory();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        if (resource != null) {
                            PaletteExtraction pe = new PaletteExtraction(view.findViewById(R.id.relativeLayout),
                                    ((BitmapDrawable) resource).getBitmap());
                            pe.execute();
                        }
                        if (!storiesStarted) {
                            storiesStarted = true;
                            storyCallbacks.startStories();
                        }
                        return false;
                    }
                })
                .into(mImageView);

        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        (container).removeView((View) object);
    }
}
