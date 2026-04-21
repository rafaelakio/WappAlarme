package br.com.wappalarme.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import br.com.wappalarme.data.model.AlarmEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlarmEntity> __insertionAdapterOfAlarmEntity;

  private final EntityDeletionOrUpdateAdapter<AlarmEntity> __deletionAdapterOfAlarmEntity;

  private final EntityDeletionOrUpdateAdapter<AlarmEntity> __updateAdapterOfAlarmEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAlarmStatus;

  private final SharedSQLiteStatement __preparedStmtOfReEnableHolidayAlarms;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public AlarmDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarmEntity = new EntityInsertionAdapter<AlarmEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `alarms` (`id`,`systemAlarmId`,`hour`,`minute`,`label`,`daysOfWeek`,`isEnabled`,`disabledForHoliday`,`holidayDisabledDate`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlarmEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSystemAlarmId());
        statement.bindLong(3, entity.getHour());
        statement.bindLong(4, entity.getMinute());
        if (entity.getLabel() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLabel());
        }
        statement.bindLong(6, entity.getDaysOfWeek());
        final int _tmp = entity.isEnabled() ? 1 : 0;
        statement.bindLong(7, _tmp);
        final int _tmp_1 = entity.getDisabledForHoliday() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        if (entity.getHolidayDisabledDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getHolidayDisabledDate());
        }
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfAlarmEntity = new EntityDeletionOrUpdateAdapter<AlarmEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `alarms` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlarmEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfAlarmEntity = new EntityDeletionOrUpdateAdapter<AlarmEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `alarms` SET `id` = ?,`systemAlarmId` = ?,`hour` = ?,`minute` = ?,`label` = ?,`daysOfWeek` = ?,`isEnabled` = ?,`disabledForHoliday` = ?,`holidayDisabledDate` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlarmEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSystemAlarmId());
        statement.bindLong(3, entity.getHour());
        statement.bindLong(4, entity.getMinute());
        if (entity.getLabel() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLabel());
        }
        statement.bindLong(6, entity.getDaysOfWeek());
        final int _tmp = entity.isEnabled() ? 1 : 0;
        statement.bindLong(7, _tmp);
        final int _tmp_1 = entity.getDisabledForHoliday() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        if (entity.getHolidayDisabledDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getHolidayDisabledDate());
        }
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateAlarmStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alarms SET isEnabled = ?, disabledForHoliday = ?, holidayDisabledDate = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfReEnableHolidayAlarms = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alarms SET isEnabled = 1, disabledForHoliday = 0, holidayDisabledDate = NULL WHERE disabledForHoliday = 1";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM alarms";
        return _query;
      }
    };
  }

  @Override
  public Object insertAlarm(final AlarmEntity alarm, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAlarmEntity.insertAndReturnId(alarm);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAlarm(final AlarmEntity alarm, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAlarmEntity.handle(alarm);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAlarm(final AlarmEntity alarm, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAlarmEntity.handle(alarm);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAlarmStatus(final long id, final boolean enabled,
      final boolean disabledForHoliday, final String date,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAlarmStatus.acquire();
        int _argIndex = 1;
        final int _tmp = enabled ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        final int _tmp_1 = disabledForHoliday ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 3;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, date);
        }
        _argIndex = 4;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfUpdateAlarmStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object reEnableHolidayAlarms(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfReEnableHolidayAlarms.acquire();
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
          __preparedStmtOfReEnableHolidayAlarms.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
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
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AlarmEntity>> getAllAlarms() {
    final String _sql = "SELECT * FROM alarms ORDER BY hour ASC, minute ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"alarms"}, new Callable<List<AlarmEntity>>() {
      @Override
      @NonNull
      public List<AlarmEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSystemAlarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "systemAlarmId");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfDaysOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "daysOfWeek");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
          final int _cursorIndexOfDisabledForHoliday = CursorUtil.getColumnIndexOrThrow(_cursor, "disabledForHoliday");
          final int _cursorIndexOfHolidayDisabledDate = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayDisabledDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AlarmEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpSystemAlarmId;
            _tmpSystemAlarmId = _cursor.getInt(_cursorIndexOfSystemAlarmId);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final int _tmpDaysOfWeek;
            _tmpDaysOfWeek = _cursor.getInt(_cursorIndexOfDaysOfWeek);
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final boolean _tmpDisabledForHoliday;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDisabledForHoliday);
            _tmpDisabledForHoliday = _tmp_1 != 0;
            final String _tmpHolidayDisabledDate;
            if (_cursor.isNull(_cursorIndexOfHolidayDisabledDate)) {
              _tmpHolidayDisabledDate = null;
            } else {
              _tmpHolidayDisabledDate = _cursor.getString(_cursorIndexOfHolidayDisabledDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new AlarmEntity(_tmpId,_tmpSystemAlarmId,_tmpHour,_tmpMinute,_tmpLabel,_tmpDaysOfWeek,_tmpIsEnabled,_tmpDisabledForHoliday,_tmpHolidayDisabledDate,_tmpCreatedAt);
            _result.add(_item);
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
  public Object getAlarmById(final long id, final Continuation<? super AlarmEntity> $completion) {
    final String _sql = "SELECT * FROM alarms WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AlarmEntity>() {
      @Override
      @Nullable
      public AlarmEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSystemAlarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "systemAlarmId");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfDaysOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "daysOfWeek");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
          final int _cursorIndexOfDisabledForHoliday = CursorUtil.getColumnIndexOrThrow(_cursor, "disabledForHoliday");
          final int _cursorIndexOfHolidayDisabledDate = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayDisabledDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final AlarmEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpSystemAlarmId;
            _tmpSystemAlarmId = _cursor.getInt(_cursorIndexOfSystemAlarmId);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final int _tmpDaysOfWeek;
            _tmpDaysOfWeek = _cursor.getInt(_cursorIndexOfDaysOfWeek);
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final boolean _tmpDisabledForHoliday;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDisabledForHoliday);
            _tmpDisabledForHoliday = _tmp_1 != 0;
            final String _tmpHolidayDisabledDate;
            if (_cursor.isNull(_cursorIndexOfHolidayDisabledDate)) {
              _tmpHolidayDisabledDate = null;
            } else {
              _tmpHolidayDisabledDate = _cursor.getString(_cursorIndexOfHolidayDisabledDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new AlarmEntity(_tmpId,_tmpSystemAlarmId,_tmpHour,_tmpMinute,_tmpLabel,_tmpDaysOfWeek,_tmpIsEnabled,_tmpDisabledForHoliday,_tmpHolidayDisabledDate,_tmpCreatedAt);
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

  @Override
  public Object getEnabledAlarms(final Continuation<? super List<AlarmEntity>> $completion) {
    final String _sql = "SELECT * FROM alarms WHERE isEnabled = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AlarmEntity>>() {
      @Override
      @NonNull
      public List<AlarmEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSystemAlarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "systemAlarmId");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfDaysOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "daysOfWeek");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
          final int _cursorIndexOfDisabledForHoliday = CursorUtil.getColumnIndexOrThrow(_cursor, "disabledForHoliday");
          final int _cursorIndexOfHolidayDisabledDate = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayDisabledDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AlarmEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpSystemAlarmId;
            _tmpSystemAlarmId = _cursor.getInt(_cursorIndexOfSystemAlarmId);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final int _tmpDaysOfWeek;
            _tmpDaysOfWeek = _cursor.getInt(_cursorIndexOfDaysOfWeek);
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final boolean _tmpDisabledForHoliday;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDisabledForHoliday);
            _tmpDisabledForHoliday = _tmp_1 != 0;
            final String _tmpHolidayDisabledDate;
            if (_cursor.isNull(_cursorIndexOfHolidayDisabledDate)) {
              _tmpHolidayDisabledDate = null;
            } else {
              _tmpHolidayDisabledDate = _cursor.getString(_cursorIndexOfHolidayDisabledDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new AlarmEntity(_tmpId,_tmpSystemAlarmId,_tmpHour,_tmpMinute,_tmpLabel,_tmpDaysOfWeek,_tmpIsEnabled,_tmpDisabledForHoliday,_tmpHolidayDisabledDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getHolidayDisabledAlarms(
      final Continuation<? super List<AlarmEntity>> $completion) {
    final String _sql = "SELECT * FROM alarms WHERE disabledForHoliday = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<AlarmEntity>>() {
      @Override
      @NonNull
      public List<AlarmEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSystemAlarmId = CursorUtil.getColumnIndexOrThrow(_cursor, "systemAlarmId");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
          final int _cursorIndexOfDaysOfWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "daysOfWeek");
          final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
          final int _cursorIndexOfDisabledForHoliday = CursorUtil.getColumnIndexOrThrow(_cursor, "disabledForHoliday");
          final int _cursorIndexOfHolidayDisabledDate = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayDisabledDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AlarmEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpSystemAlarmId;
            _tmpSystemAlarmId = _cursor.getInt(_cursorIndexOfSystemAlarmId);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final String _tmpLabel;
            if (_cursor.isNull(_cursorIndexOfLabel)) {
              _tmpLabel = null;
            } else {
              _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
            }
            final int _tmpDaysOfWeek;
            _tmpDaysOfWeek = _cursor.getInt(_cursorIndexOfDaysOfWeek);
            final boolean _tmpIsEnabled;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
            _tmpIsEnabled = _tmp != 0;
            final boolean _tmpDisabledForHoliday;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfDisabledForHoliday);
            _tmpDisabledForHoliday = _tmp_1 != 0;
            final String _tmpHolidayDisabledDate;
            if (_cursor.isNull(_cursorIndexOfHolidayDisabledDate)) {
              _tmpHolidayDisabledDate = null;
            } else {
              _tmpHolidayDisabledDate = _cursor.getString(_cursorIndexOfHolidayDisabledDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new AlarmEntity(_tmpId,_tmpSystemAlarmId,_tmpHour,_tmpMinute,_tmpLabel,_tmpDaysOfWeek,_tmpIsEnabled,_tmpDisabledForHoliday,_tmpHolidayDisabledDate,_tmpCreatedAt);
            _result.add(_item);
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
