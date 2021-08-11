package be.ehb.myrecipe.fragments.settings;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;

import be.ehb.myrecipe.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }

    public void enablePreference(){

        CheckBoxPreference checkBoxPreference = (CheckBoxPreference)findPreference("CheckNotif");
        checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object object) {

                boolean enabled = (boolean) object;
                if(enabled){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        NotificationChannel notificationChannel = new NotificationChannel("My Recipe Notification","My Recipe Notification", NotificationManager.IMPORTANCE_DEFAULT);
                        NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }

                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getActivity(), "My Recipe Notification")
                            .setSmallIcon(R.drawable.ic_notification)
                            .setContentTitle("My Recipe - New Message")
                            .setContentText("Notifications are enabled for My Recipe App.")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
                    managerCompat.notify(1,notificationBuilder.build());
                }
                return true;

            }
        });

    }

    @Override
    public void onResume() {
        enablePreference();
        super.onResume();
    }
}