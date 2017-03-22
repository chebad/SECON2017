package pl.edu.wat.wel.secon.secon2017;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        LinearLayout linearLayoutPhone = (LinearLayout) findViewById(R.id.id_phone);
        LinearLayout linearLayoutWebsite = (LinearLayout) findViewById(R.id.id_website);
        LinearLayout linearLayoutEmail = (LinearLayout) findViewById(R.id.id_email);

        linearLayoutEmail.setOnClickListener(this);
        linearLayoutPhone.setOnClickListener(this);
        linearLayoutWebsite.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_email: {
                String seconEmail = "secon@wat.edu.pl";
                String subjectEmail = getString(R.string.register);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, seconEmail);
                intent.putExtra(Intent.EXTRA_SUBJECT, subjectEmail);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.email_toast_message_error, Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.id_phone: {
                String numberPhone = "261837123";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + numberPhone));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.phone_toast_message_error, Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.id_website: {
                String websitePage = "http://secon.wel.wat.edu.pl/index.php/pl/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websitePage));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.website_toast_message_error, Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
