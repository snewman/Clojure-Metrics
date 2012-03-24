(ns metrics-riemann.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "metrics-riemann"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))
