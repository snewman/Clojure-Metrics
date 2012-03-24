(ns metrics-riemann.views.welcome
  (:require [metrics-riemann.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout
          [:p "Welcome to metrics-riemann"]))

(defpage "/my-page" []
  (common/site-layout
   [:h1 "This is my first page!"]
   [:p "Hope you like it!"]))


