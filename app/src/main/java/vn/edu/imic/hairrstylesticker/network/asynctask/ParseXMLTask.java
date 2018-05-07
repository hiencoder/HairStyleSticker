package vn.edu.imic.hairrstylesticker.network.asynctask;

import android.os.AsyncTask;

import org.w3c.dom.NodeList;

import vn.edu.imic.hairrstylesticker.view.CropImageActivity;

/**
 * Created by MyPC on 04/05/2018.
 */

public class ParseXMLTask extends AsyncTask<String, Void, NodeList>{
    CropImageActivity cropImageActivity;

    public ParseXMLTask(CropImageActivity cropImageActivity) {
        this.cropImageActivity = cropImageActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected NodeList doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(NodeList nodeList) {
        super.onPostExecute(nodeList);
    }

    /*
    public class AsyncTaskRunner extends AsyncTask<String, Void, NodeList> {
        final */
/* synthetic *//*
 ChooseOption a;

        public AsyncTaskRunner(ChooseOption chooseOption) {
            this.a = chooseOption;
        }

        protected NodeList a(String... strArr) {
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "2131427360Demo.xml").getPath())));
                parse.getDocumentElement().normalize();
                NodeList elementsByTagName = parse.getElementsByTagName(MimeTypes.BASE_TYPE_APPLICATION);
                System.out.println("Node" + elementsByTagName.getLength());
                this.a.s = new String[elementsByTagName.getLength()];
                return elementsByTagName;
            } catch (Exception e) {
                System.out.println("XML Pasing Excpetion = " + e);
                return null;
            }
        }

        protected void a(NodeList nodeList) {
            int i = 0;
            while (i < nodeList.getLength()) {
                try {
                    Element element = (Element) nodeList.item(i);
                    String nodeValue = ((Element) element.getElementsByTagName("apkid").item(0)).getChildNodes().item(0).getNodeValue();
                    System.out.println(Param.VALUE + nodeValue);
                    this.a.s[i] = nodeValue;
                    String nodeValue2 = ((Element) element.getElementsByTagName("appname").item(0)).getChildNodes().item(0).getNodeValue();
                    System.out.println(Param.VALUE + nodeValue2);
                    String nodeValue3 = ((Element) element.getElementsByTagName("imageurl").item(0)).getChildNodes().item(0).getNodeValue();
                    System.out.println(Param.VALUE + nodeValue3);
                    this.a.updateAd(i, nodeValue, nodeValue3, nodeValue2);
                    i++;
                } catch (Exception e) {
                    return;
                }
            }
        }

        protected */
/* synthetic *//*
 Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        protected */
/* synthetic *//*
 void onPostExecute(Object obj) {
            a((NodeList) obj);
        }

        protected void onPreExecute() {
        }
    }
*/


}
