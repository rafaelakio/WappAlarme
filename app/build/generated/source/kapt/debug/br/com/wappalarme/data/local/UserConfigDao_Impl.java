package br.com.wappalarme.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import br.com.wappalarme.data.model.UserConfig;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserConfigDao_Impl implements UserConfigDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserConfig> __insertionAdapterOfUserConfig;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastCheckDate;

  public UserConfigDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserConfig = new EntityInsertionAdapter<UserConfig>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_config` (`id`,`city`,`state`,`cityIbgeCode`,`checkMunicipalHolidays`,`holidayCheckTime`,`holidayNotificationsEnabled`,`lastHolidayCheckDate`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserConfig entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCity() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCity());
        }
        if (entity.getState() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getState());
        }
        if (entity.getCityIbgeCode() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCityIbgeCode());
        }
        final int _tmp = entity.getCheckMunicipalHolidays() ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.getHolidayCheckTime() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getHolidayCheckTime());
        }
        final int _tmp_1 = entity.getHolidayNotificationsEnabled() ? 1 : 0;
        statement.bindLong(7, _tmp_1);
        if (entity.getLastHolidayCheckDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getLastHolidayCheckDate());
        }
      }
    };
    this.__preparedStmtOfUpdateLastCheckDate = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE user_config SET lastHolidayCheckDate = ? WHERE id = 1";
        return _query;
      }
    };
  }

  @Override
  public Object saveConfig(final UserConfig config, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserConfig.insert(config);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLastCheckDate(final String date,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastCheckDate.acquire();
        int _argIndex = 1;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, date);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLastCheckDate.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<UserConfig> getConfig() {
    final String _sql = "SELECT * FROM user_config WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"user_config"}, new Callable<UserConfig>() {
      @Override
      @Nullable
      public UserConfig call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCityIbgeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cityIbgeCode");
          final int _cursorIndexOfCheckMunicipalHolidays = CursorUtil.getColumnIndexOrThrow(_cursor, "checkMunicipalHolidays");
          final int _cursorIndexOfHolidayCheckTime = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayCheckTime");
          final int _cursorIndexOfHolidayNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayNotificationsEnabled");
          final int _cursorIndexOfLastHolidayCheckDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastHolidayCheckDate");
          final UserConfig _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCityIbgeCode;
            if (_cursor.isNull(_cursorIndexOfCityIbgeCode)) {
              _tmpCityIbgeCode = null;
            } else {
              _tmpCityIbgeCode = _cursor.getString(_cursorIndexOfCityIbgeCode);
            }
            final boolean _tmpCheckMunicipalHolidays;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCheckMunicipalHolidays);
            _tmpCheckMunicipalHolidays = _tmp != 0;
            final String _tmpHolidayCheckTime;
            if (_cursor.isNull(_cursorIndexOfHolidayCheckTime)) {
              _tmpHolidayCheckTime = null;
            } else {
              _tmpHolidayCheckTime = _cursor.getString(_cursorIndexOfHolidayCheckTime);
            }
            final boolean _tmpHolidayNotificationsEnabled;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHolidayNotificationsEnabled);
            _tmpHolidayNotificationsEnabled = _tmp_1 != 0;
            final String _tmpLastHolidayCheckDate;
            if (_cursor.isNull(_cursorIndexOfLastHolidayCheckDate)) {
              _tmpLastHolidayCheckDate = null;
            } else {
              _tmpLastHolidayCheckDate = _cursor.getString(_cursorIndexOfLastHolidayCheckDate);
            }
            _result = new UserConfig(_tmpId,_tmpCity,_tmpState,_tmpCityIbgeCode,_tmpCheckMunicipalHolidays,_tmpHolidayCheckTime,_tmpHolidayNotificationsEnabled,_tmpLastHolidayCheckDate);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getConfigOnce(final Continuation<? super UserConfig> $completion) {
    final String _sql = "SELECT * FROM user_config WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserConfig>() {
      @Override
      @Nullable
      public UserConfig call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCityIbgeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "cityIbgeCode");
          final int _cursorIndexOfCheckMunicipalHolidays = CursorUtil.getColumnIndexOrThrow(_cursor, "checkMunicipalHolidays");
          final int _cursorIndexOfHolidayCheckTime = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayCheckTime");
          final int _cursorIndexOfHolidayNotificationsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayNotificationsEnabled");
          final int _cursorIndexOfLastHolidayCheckDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastHolidayCheckDate");
          final UserConfig _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCityIbgeCode;
            if (_cursor.isNull(_cursorIndexOfCityIbgeCode)) {
              _tmpCityIbgeCode = null;
            } else {
              _tmpCityIbgeCode = _cursor.getString(_cursorIndexOfCityIbgeCode);
            }
            final boolean _tmpCheckMunicipalHolidays;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCheckMunicipalHolidays);
            _tmpCheckMunicipalHolidays = _tmp != 0;
            final String _tmpHolidayCheckTime;
            if (_cursor.isNull(_cursorIndexOfHolidayCheckTime)) {
              _tmpHolidayCheckTime = null;
            } else {
              _tmpHolidayCheckTime = _cursor.getString(_cursorIndexOfHolidayCheckTime);
            }
            final boolean _tmpHolidayNotificationsEnabled;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHolidayNotificationsEnabled);
            _tmpHolidayNotificationsEnabled = _tmp_1 != 0;
            final String _tmpLastHolidayCheckDate;
            if (_cursor.isNull(_cursorIndexOfLastHolidayCheckDate)) {
              _tmpLastHolidayCheckDate = null;
            } else {
              _tmpLastHolidayCheckDate = _cursor.getString(_cursorIndexOfLastHolidayCheckDate);
            }
            _result = new UserConfig(_tmpId,_tmpCity,_tmpState,_tmpCityIbgeCode,_tmpCheckMunicipalHolidays,_tmpHolidayCheckTime,_tmpHolidayNotificationsEnabled,_tmpLastHolidayCheckDate);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
