package party.danyang.syncadapter.account;

import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by dream on 16-11-6.
 */

public class Account {

    // The authority for the sync adapter's content provider
    public static final String AUTHORITY = "party.danyang.syncadapter.provider";
    // An account type, in the form of a domain name
    public static final String ACCOUNT_TYPE = "party.danyang.syncadapter";
    // The account name
    public static final String ACCOUNT = "syncadapter";

    private static Account wallpaperAccount;
    private Context context;
    private AccountManager am;

    private Account(Context context) {
        this.context = context;
        this.am = AccountManager.get(context);
    }

    public static Account getInstance(Context context) {
        if (wallpaperAccount == null)
            wallpaperAccount = new Account(context);
        return wallpaperAccount;
    }

    public android.accounts.Account getAccount() {
        final android.accounts.Account[] accounts = am.getAccountsByType(ACCOUNT_TYPE);
        if (accounts.length > 0)
            return accounts[0];

        final android.accounts.Account account = new android.accounts.Account(ACCOUNT, ACCOUNT_TYPE);
        am.addAccountExplicitly(account, null, Bundle.EMPTY);
        return account;
    }
}
