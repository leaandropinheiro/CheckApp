import { routes as auth } from "@/views";
import { routes as home } from "@/modules/auth";

export default [...auth, ...home];
