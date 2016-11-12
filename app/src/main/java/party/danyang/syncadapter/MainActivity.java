package party.danyang.syncadapter;

import android.accounts.Account;
import android.content.ContentResolver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Account account = party.danyang.syncadapter.account.Account.getInstance(this).getAccount();

        ContentResolver.setIsSyncable(account, party.danyang.syncadapter.account.Account.AUTHORITY, 1);
        ContentResolver.addPeriodicSync(account, party.danyang.syncadapter.account.Account.AUTHORITY, Bundle.EMPTY, TimeUnit.SECONDS.toSeconds(5));
        ContentResolver.setSyncAutomatically(account, party.danyang.syncadapter.account.Account.AUTHORITY, true);
    }
}
