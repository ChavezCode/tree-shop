// import {polygonContains, forceCollide, forceX} from "https://cdn.jsdelivr.net/npm/d3-force@3/+esm";
// // const nodes = [{}, {}];
// // const simulation = forceSimulation(nodes).
// //     force("x", forceX()).
// //     force("collide", forceCollide(5)).
// //     on("tick", () => console.log(nodes[0].x));
// //
// // var containsGeometryType = {
// //     MultiPoint: function(object, point) {
// //         var coordinates = object.coordinates, i = -1, n = coordinates.length;
// //         while (++i < n) if (containsPoint(coordinates[i], point)) return true;
// //         return false;
// //     },
// //

import * as turf from '@turf/turf';

const point = turf.point([5,6])