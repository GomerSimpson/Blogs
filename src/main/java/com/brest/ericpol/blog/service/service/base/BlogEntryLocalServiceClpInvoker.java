package com.brest.ericpol.blog.service.service.base;

import com.brest.ericpol.blog.service.service.BlogEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Viktor Kolbik
 * @generated
 */
public class BlogEntryLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;

    public BlogEntryLocalServiceClpInvoker() {
        _methodName0 = "addBlogEntry";

        _methodParameterTypes0 = new String[] {
                "com.brest.ericpol.blog.service.model.BlogEntry"
            };

        _methodName1 = "createBlogEntry";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteBlogEntry";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteBlogEntry";

        _methodParameterTypes3 = new String[] {
                "com.brest.ericpol.blog.service.model.BlogEntry"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchBlogEntry";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getBlogEntry";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getBlogEntries";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getBlogEntriesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateBlogEntry";

        _methodParameterTypes15 = new String[] {
                "com.brest.ericpol.blog.service.model.BlogEntry"
            };

        _methodName32 = "getBeanIdentifier";

        _methodParameterTypes32 = new String[] {  };

        _methodName33 = "setBeanIdentifier";

        _methodParameterTypes33 = new String[] { "java.lang.String" };

        _methodName38 = "addBlogEntry";

        _methodParameterTypes38 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.lang.String", "java.lang.String", "java.sql.Date"
            };

        _methodName39 = "updateBlogEntry";

        _methodParameterTypes39 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "java.sql.Date"
            };

        _methodName40 = "findByUserGroupCompanyId";

        _methodParameterTypes40 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.Long"
            };

        _methodName41 = "findAllEntries";

        _methodParameterTypes41 = new String[] {  };

        _methodName42 = "findByGroupId";

        _methodParameterTypes42 = new String[] { "long" };

        _methodName43 = "findByDateLaterThan";

        _methodParameterTypes43 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.sql.Date"
            };

        _methodName44 = "findByDateEarlierThan";

        _methodParameterTypes44 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.sql.Date"
            };

        _methodName45 = "findByTimePeriod";

        _methodParameterTypes45 = new String[] {
                "java.lang.Long", "java.lang.Long", "java.lang.Long",
                "java.sql.Date", "java.sql.Date"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return BlogEntryLocalServiceUtil.addBlogEntry((com.brest.ericpol.blog.service.model.BlogEntry) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return BlogEntryLocalServiceUtil.createBlogEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return BlogEntryLocalServiceUtil.deleteBlogEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return BlogEntryLocalServiceUtil.deleteBlogEntry((com.brest.ericpol.blog.service.model.BlogEntry) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return BlogEntryLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return BlogEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return BlogEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return BlogEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return BlogEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return BlogEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return BlogEntryLocalServiceUtil.fetchBlogEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return BlogEntryLocalServiceUtil.getBlogEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return BlogEntryLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return BlogEntryLocalServiceUtil.getBlogEntries(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return BlogEntryLocalServiceUtil.getBlogEntriesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return BlogEntryLocalServiceUtil.updateBlogEntry((com.brest.ericpol.blog.service.model.BlogEntry) arguments[0]);
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return BlogEntryLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            BlogEntryLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            return BlogEntryLocalServiceUtil.addBlogEntry((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.Long) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4], (java.sql.Date) arguments[5]);
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            return BlogEntryLocalServiceUtil.updateBlogEntry((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.Long) arguments[2],
                (java.lang.Long) arguments[3], (java.lang.String) arguments[4],
                (java.lang.String) arguments[5], (java.sql.Date) arguments[6]);
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return BlogEntryLocalServiceUtil.findByUserGroupCompanyId((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.Long) arguments[2]);
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            return BlogEntryLocalServiceUtil.findAllEntries();
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return BlogEntryLocalServiceUtil.findByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return BlogEntryLocalServiceUtil.findByDateLaterThan((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.Long) arguments[2],
                (java.sql.Date) arguments[3]);
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return BlogEntryLocalServiceUtil.findByDateEarlierThan((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.Long) arguments[2],
                (java.sql.Date) arguments[3]);
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return BlogEntryLocalServiceUtil.findByTimePeriod((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1], (java.lang.Long) arguments[2],
                (java.sql.Date) arguments[3], (java.sql.Date) arguments[4]);
        }

        throw new UnsupportedOperationException();
    }
}
