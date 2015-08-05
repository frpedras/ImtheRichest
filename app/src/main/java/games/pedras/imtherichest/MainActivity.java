package games.pedras.imtherichest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coins = (TextView) findViewById(R.id.coins);
        updateCoins(0);
    }

    public void buyone(View v) {
        updateCoins(1);
    }

    public void buyten(View v) {
        updateCoins(9);
    }

    public void buyhundred(View v) {
        updateCoins(99);
    }

    public void buymil(View v) {
        updateCoins(999);
    }

    public void updateCoins(int x) {
        SharedPreferences prefs = this.getSharedPreferences("games.pedras.imtherichest", Context.MODE_PRIVATE);
        int coin;
        try {
            coin = prefs.getInt("coins", 0);
        } catch (Exception e) {
            coin = 0;
        }
        coin += x;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("coins", coin);
        editor.commit();
        coins.setText(""+ coin);
    }
}
