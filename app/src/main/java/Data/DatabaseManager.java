package Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.floozmanager.Decimal;
import com.floozmanager.Resultats;

/**
 * servira à encapsuler les DAOs afin de faciliter l'utilisation de ces derniers. Il contiendra par exemple une méthode statique
 * "saveUser(User)" qui, dans sa mécanique interne, fera appel au DAO de l'entité "User" pour en effectuer la persistance.
 * Ce fichier n'a d'intêret que pour les projets de petite taille n'ayant pas plus de quelques DAOs, ce qui devrait suffir
 * le plus souvent pour des projets mobiles. Pour les projets de tailles plus conséquentes, il sera fortement conseillé de
 * créer un objet "DaoFoo" pour chaque objet qui sera instancié et appelé séparement au besoin.
 */
public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Flooz.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(@Nullable Context context/*-, @Nullable SQLiteDatabase.CursorFactory factory*/) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQL = "CREATE TABLE T_Resultats ("
                + " idResultats integer primary key autoincrement,"
                + " ChiffreAffaire text,"
                + " Perte text,"
                + " Benefice text"
                + ")";
        db.execSQL(strSQL);
        Log.d("DataBase","OnCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Mise à jour de la base
        String strSQL = "DROP TABLE T_Resultats";
        db.execSQL(strSQL);
        Log.d("DataBase","OnUpgrade");
        this.onCreate(db);
    }

    public void insertResultat(Resultats resultats) {
        String strSQL = "INSERT INTO T_Resultats (ChiffreAffaire, Perte, Benefice) VALUES ('"
        + resultats.toStringChiffreAffaire() + "', '" + resultats.toStringPerte() +"', '" + resultats.toStringBenefice() +"')";
        this.getWritableDatabase().execSQL(strSQL);
        Log.d("DataBase","InsertResultats");
    }
}
