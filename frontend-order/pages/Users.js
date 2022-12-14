import { useRouter } from "next/router"
import { useEffect, useState } from "react"
import LayoutAuthenticated from "../components/layout-authenticated"
import styles from "../styles/styles.module.css"

export default function Users() {
    const [content, setContent] = useState(null)
    const router = useRouter()

    useEffect(() => {
        fetchContent()
    }, [])


    async function fetchContent() {
        const res = await fetch(`http://localhost:9090/api/test/user`, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("token")
            }
        })
        if (res.ok) {
            const text = await res.text()
            setContent(text)
        }
    }

    return (
        <LayoutAuthenticated>
            <div className={styles.container}>
                <h1 className={styles.title}>User</h1>
                {content && (
                    <p>{content}</p>
                )}
            </div>
        </LayoutAuthenticated>
    )
}