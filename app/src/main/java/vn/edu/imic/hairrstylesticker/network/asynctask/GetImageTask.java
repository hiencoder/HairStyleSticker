package vn.edu.imic.hairrstylesticker.network.asynctask;

/**
 * Created by MyPC on 04/05/2018.
 */

public class GetImageTask {
/*
    public class GetImageClass extends AsyncTask<String, Void, Bitmap> {
        final */
/* synthetic *//*
 ChooseOption a;
        private ImageButton button;
        private String imageUrl;

        private GetImageClass(ChooseOption chooseOption, String str, ImageButton imageButton) {
            this.a = chooseOption;
            this.imageUrl = str;
            this.button = imageButton;
        }

        protected Bitmap a(String... strArr) {
            try {
                return BitmapFactory.decodeStream(new URL(this.imageUrl).openConnection().getInputStream());
            } catch (Exception e) {
                return null;
            }
        }

        protected void a(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.button.setImageBitmap(bitmap);
        }

        protected */
/* synthetic *//*
 Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        protected */
/* synthetic *//*
 void onPostExecute(Object obj) {
            a((Bitmap) obj);
        }
    }
*/


}
