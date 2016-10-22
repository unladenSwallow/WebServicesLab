package edu.uw.tacoma.pedrol.webserviceslab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lesliepedro on 10/21/16.
 */

public class Course implements Serializable {

    public static final String ID = "id";

    public static final String SHORT_DESC = "shortDesc";

    public static final String LONG_DESC = "longDesc";

    public static final String PRE_REQS = "prereqs";

    private String mCourseId;

    private String mShortDescription;

    private String mLongDescription;

    private String mPrereqs;

    public Course(String id, String shDesc, String lgDesc, String prereqs) {
        this.mCourseId = id;
        this.mShortDescription = shDesc;
        this.mLongDescription = lgDesc;
        this.mPrereqs = prereqs;
    }

    public String getmCourseId() {
        return mCourseId;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }

    public String getmLongDescription() {
        return mLongDescription;
    }

    public String getmPrereqs() {
        return mPrereqs;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public void setmShortDescription(String mShortDescription) {
        this.mShortDescription = mShortDescription;
    }

    public void setmLongDescription(String mLongDescription) {
        this.mLongDescription = mLongDescription;
    }

    public void setmPrereqs(String mPrereqs) {
        this.mPrereqs = mPrereqs;
    }

    /**
     * Parses the json String, returns an error message if unsuccessful.
     * Returns the list of courses if successful.
     * @param courseJSON
     * @return reason or null if successful.
     */
    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if(courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID),
                            obj.getString(Course.SHORT_DESC), obj.getString(Course.LONG_DESC),
                            obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason = "Unable to parse data, Reason: " + e.getMessage();
            }
        }
    }

}
