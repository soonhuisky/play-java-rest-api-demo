package apple.module;

import com.google.inject.Key;
import com.google.inject.Provider;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import play.db.Database;
import play.db.NamedDatabaseImpl;

public class MybatisModule extends MyBatisModule {

    @Override
    protected void initialize() {
        environmentId("default");
        // 获取命名为 my-db 的数据源 Provider
        Provider<Database> provider = binder().getProvider(Key.get(Database.class, new NamedDatabaseImpl("apple")));
        bindDataSourceProvider(() -> provider.get().getDataSource());
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        // 配置 Dao 类所在的包
        addMapperClasses("apple.mapper");
    }
}
