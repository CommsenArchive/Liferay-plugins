package com.commsen.liferay.portlet.customglobalmarkup.service;

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.NullWrapper;


public class MarkupLocalServiceClp implements MarkupLocalService {
    private ClassLoaderProxy _classLoaderProxy;

    public MarkupLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup addMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(markup);

        if (markup == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.portlet.customglobalmarkup.model.Markup");
        }

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("addMarkup",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.portlet.customglobalmarkup.model.Markup) ClpSerializer.translateOutput(returnObj);
    }

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup createMarkup(
        long id) {
        Object paramObj0 = new LongWrapper(id);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("createMarkup",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.portlet.customglobalmarkup.model.Markup) ClpSerializer.translateOutput(returnObj);
    }

    public void deleteMarkup(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        Object paramObj0 = new LongWrapper(id);

        try {
            _classLoaderProxy.invoke("deleteMarkup", new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.PortalException) {
                throw (com.liferay.portal.PortalException) t;
            }

            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deleteMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(markup);

        if (markup == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.portlet.customglobalmarkup.model.Markup");
        }

        try {
            _classLoaderProxy.invoke("deleteMarkup", new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

        if (dynamicQuery == null) {
            paramObj0 = new NullWrapper(
                    "com.liferay.portal.kernel.dao.orm.DynamicQuery");
        }

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("dynamicQuery",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<Object>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

        if (dynamicQuery == null) {
            paramObj0 = new NullWrapper(
                    "com.liferay.portal.kernel.dao.orm.DynamicQuery");
        }

        Object paramObj1 = new IntegerWrapper(start);

        Object paramObj2 = new IntegerWrapper(end);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("dynamicQuery",
                    new Object[] { paramObj0, paramObj1, paramObj2 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<Object>) ClpSerializer.translateOutput(returnObj);
    }

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup getMarkup(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        Object paramObj0 = new LongWrapper(id);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getMarkup",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.PortalException) {
                throw (com.liferay.portal.PortalException) t;
            }

            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.portlet.customglobalmarkup.model.Markup) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        int start, int end) throws com.liferay.portal.SystemException {
        Object paramObj0 = new IntegerWrapper(start);

        Object paramObj1 = new IntegerWrapper(end);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getMarkups",
                    new Object[] { paramObj0, paramObj1 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup>) ClpSerializer.translateOutput(returnObj);
    }

    public int getMarkupsCount() throws com.liferay.portal.SystemException {
        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getMarkupsCount",
                    new Object[0]);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup)
        throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(markup);

        if (markup == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.portlet.customglobalmarkup.model.Markup");
        }

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("updateMarkup",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.portlet.customglobalmarkup.model.Markup) ClpSerializer.translateOutput(returnObj);
    }

    public com.commsen.liferay.portlet.customglobalmarkup.model.Markup updateMarkup(
        com.commsen.liferay.portlet.customglobalmarkup.model.Markup markup,
        boolean merge) throws com.liferay.portal.SystemException {
        Object paramObj0 = ClpSerializer.translateInput(markup);

        if (markup == null) {
            paramObj0 = new NullWrapper(
                    "com.commsen.liferay.portlet.customglobalmarkup.model.Markup");
        }

        Object paramObj1 = new BooleanWrapper(merge);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("updateMarkup",
                    new Object[] { paramObj0, paramObj1 });
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.SystemException) {
                throw (com.liferay.portal.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.commsen.liferay.portlet.customglobalmarkup.model.Markup) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getMarkups(
        long groupId) {
        Object paramObj0 = new LongWrapper(groupId);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getMarkups",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveTopMarkups(
        long groupId) {
        Object paramObj0 = new LongWrapper(groupId);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getActiveTopMarkups",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup> getActiveBottomMarkups(
        long groupId) {
        Object paramObj0 = new LongWrapper(groupId);

        Object returnObj = null;

        try {
            returnObj = _classLoaderProxy.invoke("getActiveBottomMarkups",
                    new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.commsen.liferay.portlet.customglobalmarkup.model.Markup>) ClpSerializer.translateOutput(returnObj);
    }

    public void activate(long id) {
        Object paramObj0 = new LongWrapper(id);

        try {
            _classLoaderProxy.invoke("activate", new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deactivate(long id) {
        Object paramObj0 = new LongWrapper(id);

        try {
            _classLoaderProxy.invoke("deactivate", new Object[] { paramObj0 });
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
